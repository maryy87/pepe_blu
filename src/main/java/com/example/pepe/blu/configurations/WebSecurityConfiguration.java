package com.example.pepe.blu.configurations;

import com.example.pepe.blu.filters.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfiguration {

    private final JwtRequestFilter jwtRequestFilter;
    @Autowired
    public WebSecurityConfiguration(JwtRequestFilter jwtRequestFilter){this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        return security.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/signup", "/login").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/api/**")
                .authenticated()
                .and()
                .authorizeHttpRequests().requestMatchers("/Articolo/**")
                .authenticated()
                .and()
                .authorizeHttpRequests().requestMatchers("/bevande/**")
                .authenticated()
                .and()
                .authorizeHttpRequests().requestMatchers("/department/**")
                .authenticated()
                .and()
                .authorizeHttpRequests().requestMatchers("/employer/**")
                .authenticated()
                .and()
                .authorizeHttpRequests().requestMatchers("/paymentEmployer/**")
                .authenticated()
                .and()
                .authorizeHttpRequests().requestMatchers("/piatto/**")
                .authenticated()
                .and()
                .authorizeHttpRequests().requestMatchers("/tavolo/**")
                .authenticated()
                .and()
                .authorizeHttpRequests().requestMatchers("/prenotazione/**")
                .authenticated()
                .and()
                .authorizeHttpRequests().requestMatchers("/ordine/**")
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .build();    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
