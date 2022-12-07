package com.gachaapi.Security.Config;


import com.gachaapi.Security.Service.GachaUserDetailsService;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.proc.SecurityContext;
import lombok.AllArgsConstructor;
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

import static com.gachaapi.Service.Constants.ADMIN_ROLE;
import static com.gachaapi.Service.Constants.USER_ROLE;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private RsaKeyProperties rsaKeys;
    private GachaUserDetailsService gachaUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf()
                .disable()
                .userDetailsService(gachaUserDetailsService)
                .authorizeRequests(auth -> {
                    auth.antMatchers("/signup", "/token").permitAll();
//                    auth.antMatchers("/dev/**", "/assets/style.css").access("hasIpAddress('127.0.0.1') or hasIpAddress('::1') or hasAuthority('ADMIN') or hasAuthority('SCOPE_ADMIN')");
                    auth.antMatchers("/dev/**", "/assets/style.css", "/images/**").hasAnyAuthority(ADMIN_ROLE);
                    auth.antMatchers("/players").hasAuthority("SCOPE_"+ADMIN_ROLE);
                    auth.anyRequest().hasAuthority("SCOPE_"+USER_ROLE);
//                    auth.anyRequest().permitAll();
                })
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
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
}
