package br.com.life.EncurtadorDeURL.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean // server para expor o retorno do metodo
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        /**
         * desabilitar a protecao contra ataques CSRF(Cross-Site Request Forgery);
         * token que vamos usar ja protege contra esse ataque
         */

        try {
            return http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and().authorizeHttpRequests()
                    .requestMatchers(HttpMethod.POST, "/login").permitAll() //diz para o spring que o /login quando for utilizar o metodo POST, ele esta permitido
                    .anyRequest().authenticated()// aqui ele libera apenas se o usuario estiver authenticado
                    .and().addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class) // aqui diz para o Spring qual filtro tem que vir antes, ou seja , o nosso filtro tem que vir antes por conta que o Spring valida se o usuario esta logado ou nao
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
