package com.gachaapi.Security.Config;


import com.gachaapi.Security.Service.GachaUserDetailsService;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.proc.SecurityContext;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashMap;
import java.util.Map;

import static com.gachaapi.Utils.Constants.*;


@Configuration
@EnableWebSecurity

public class SecurityConfig {


    @Autowired
    private RsaKeyProperties rsaKeys;
    @Autowired
    private GachaUserDetailsService gachaUserDetailsService;

    private static final String[] NO_AUTH_URLS = {"/","/api/signup", "/token","/pay","/error", "/assets/**", "/images/**","/new-account"};
    private static final String[] ADMIN_ONLY_URLS = {"/dev/**"};
    private static final String[] USER_BASIC_ALLOWED_URLS = {"/game/**"};
    private static final String[] USER_TOKEN_ALLOWED_URLS = {"/api/**"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf()
                .disable()
                .userDetailsService(gachaUserDetailsService)
                .authorizeRequests(auth -> {
                    auth.antMatchers(NO_AUTH_URLS).permitAll();
                    auth.antMatchers(ADMIN_ONLY_URLS).hasAnyAuthority(ADMIN_ROLE, ADMIN_ROLE_TOKEN);
                    auth.antMatchers(USER_BASIC_ALLOWED_URLS).hasAuthority(USER_ROLE);
                    auth.antMatchers(USER_TOKEN_ALLOWED_URLS).hasAuthority(USER_ROLE_TOKEN);
//                    auth.anyRequest().hasIpAddress("localhost");
//                    auth.anyRequest().permitAll();
                })
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .httpBasic(Customizer.withDefaults())
                .formLogin(c -> c.loginPage("/login")
                        .defaultSuccessUrl("/", false)
                        .permitAll()
                        .usernameParameter("nick")
                        .passwordParameter("password"))
                .logout()
                .logoutSuccessUrl("/login")
                .and()
                .build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(rsaKeys.publicKey()).build();
    }

    @Bean
    JwtEncoder jwtEncoder() {
        RSAKey jwk = new RSAKey.Builder(rsaKeys.publicKey()).privateKey(rsaKeys.privateKey()).build();
        ImmutableJWKSet<SecurityContext> jwkSet = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwkSet);
    }

    @Value("${paypal.client.id}")
    private String clientId;
    @Value("${paypal.client.secret}")
    private String clientSecret;
    @Value("${paypal.mode}")
    private String mode;


    @Bean
    public Map<String, String> paypalSdkConfig() {
        Map<String, String> configMap = new HashMap<>();
        configMap.put("mode", mode);
        return configMap;
    }

    @Bean
    public OAuthTokenCredential oAuthTokenCredential() {
        return new OAuthTokenCredential(clientId, clientSecret, paypalSdkConfig());
    }

    @Bean
    public APIContext apiContext() throws PayPalRESTException {
        APIContext context = new APIContext(oAuthTokenCredential().getAccessToken());
        context.setConfigurationMap(paypalSdkConfig());
        return context;
    }
}
