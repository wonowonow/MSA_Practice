package com.sparta.msa_exam.gateway.filter.global;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter implements GlobalFilter {

    @Value("${service.jwt.secret-key}")
    private String secretKey;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String path = exchange.getRequest().getURI().getPath();

        if (path.equals("/auth/signIn") || path.equals("/auth/signUp")) {
            return chain.filter(exchange);
        }

        String token = extractToken(exchange);

        if (token == null || !validateToken(token)) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }

    private String extractToken(ServerWebExchange exchange) {

        String token = exchange.getRequest().getHeaders().getFirst("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            return token.substring(7);
        }

        return null;
    }

    private boolean validateToken(String token) {
        try {

            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));
            Jws<Claims> claimsJws = Jwts.parser()
                                        .verifyWith(key)
                                        .build()
                                        .parseSignedClaims(token);

            if (claimsJws.getPayload().getExpiration().getTime() < System.currentTimeMillis()) {
                return false;
            }

            return true;
        } catch (Exception e) {

            return false;
        }
    }
}
