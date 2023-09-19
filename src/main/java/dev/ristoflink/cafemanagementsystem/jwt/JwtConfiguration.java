package dev.ristoflink.cafemanagementsystem.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//had to create this class to fix Bean error withing JwtFilter..
@Configuration
public class JwtConfiguration {

    @Bean
    public Claims jwtClaims() {
        // Create and configure the Claims bean
        return new DefaultClaims();
    }
}
