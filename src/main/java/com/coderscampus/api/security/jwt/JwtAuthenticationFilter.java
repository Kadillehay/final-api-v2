package com.coderscampus.api.security.jwt;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtDecoder decoder;
	
	@Autowired
	private JwtToPrincipalConverter jwtToPrincipalConverter;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		extractTokenFromRequest(request)
			.map(decoder::decode)
				.map(jwtToPrincipalConverter::convert)
					.map(FarmUserDetailsAuthToken::new)
						.ifPresent(authentication -> SecurityContextHolder.getContext().setAuthentication(authentication));
//		System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		filterChain.doFilter(request, response);
		
	}
	
	private Optional<String> extractTokenFromRequest(HttpServletRequest request) {
		var token = request.getHeader("Authorization");
		if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
			return Optional.of(token.substring(7));
		}
		
		return Optional.empty();
	}

}
