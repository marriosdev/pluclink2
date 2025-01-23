package com.pluclink.api.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/links/**").permitAll() // Rotas públicas
                .anyRequest().authenticated()             // Todas as outras rotas precisam de autenticação
            )
            .csrf().disable() // Opcional: desativa CSRF, dependendo da aplicação
            .httpBasic();     // Exemplo: usa autenticação HTTP básica (pode ser ajustado)

        return http.build();
    }
}
