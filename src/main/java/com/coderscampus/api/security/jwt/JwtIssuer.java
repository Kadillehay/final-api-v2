package com.coderscampus.api.security.jwt;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JwtIssuer {
	@Autowired
	private JwtProperties jwtProperties;
	
	public String issue(long userId, String emailAddress, String roles) {
		return JWT.create()
				.withSubject(String.valueOf(userId))
				.withExpiresAt(Instant.now().plus(Duration.of(5, ChronoUnit.DAYS)))
				.withClaim("email", emailAddress)
				.withClaim("roles", roles)
				
				.sign(Algorithm.HMAC256(jwtProperties.getSecretKey()));
	}
}
