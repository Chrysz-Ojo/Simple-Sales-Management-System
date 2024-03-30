package com.chrysz.simple.sale.management.system.configuration;


import lombok.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {
        @Value("${app.jwtSecret}")
        private String jwtSecret;

        @Value("${app.jwtExpirationInMs}")
        private int jwtExpirationInMs;

        public String generateToken(Authentication authentication) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            Date now = new Date();
            Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
            return Jwts.builder()
                    .setSubject(userDetails.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(expiryDate)
                    .signWith(SignatureAlgorithm.HS512, jwtSecret)
                    .compact();
        }


    }

