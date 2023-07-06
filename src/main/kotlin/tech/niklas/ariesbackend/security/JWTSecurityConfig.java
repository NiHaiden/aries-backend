package tech.niklas.ariesbackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class JWTSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authz -> authz.requestMatchers(HttpMethod.GET, "/users/**").
                        hasAuthority("SCOPE_READ").
                        anyRequest().
                        authenticated()).
                oauth2ResourceServer(oauth2 -> oauth2.jwt(jwtConfigurer -> jwtConfigurer.
                        jwkSetUri("https://auth.niklas.tech/realms/aries/protocol/openid-connect/certs"))).oauth2Login(Customizer.withDefaults()).oauth2Client(Customizer.withDefaults());
        return http.build();
    }

}
