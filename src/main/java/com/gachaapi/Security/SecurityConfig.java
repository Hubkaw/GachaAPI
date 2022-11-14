package com.gachaapi.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static com.gachaapi.Service.Constants.ADMIN_ROLE;
import static com.gachaapi.Service.Constants.USER_ROLE;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    GachaUserDetailsService gachaUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .userDetailsService(gachaUserDetailsService)
                .authorizeRequests(auth -> {
                    auth.antMatchers("/signup").permitAll();
                    auth.antMatchers("/**").hasAuthority(ADMIN_ROLE);
                    auth.anyRequest().hasAuthority(USER_ROLE);
                })
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }
}
