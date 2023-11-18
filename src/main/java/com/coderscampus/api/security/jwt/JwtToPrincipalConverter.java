package com.coderscampus.api.security.jwt;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.coderscampus.api.security.FarmUserDetails;

@Component
public class JwtToPrincipalConverter {

	public FarmUserDetails convert(DecodedJWT jwt) {
		FarmUserDetails farmUserDetails = new FarmUserDetails();
		farmUserDetails.setUserId(Long.valueOf(jwt.getSubject()));
		farmUserDetails.setUsername(jwt.getClaim("email").asString());
		farmUserDetails.setAuthorities(extractAuthoritiesFromClaim(jwt));
		return farmUserDetails;

	}

	private String extractAuthoritiesFromClaim(DecodedJWT jwt) {
		var claim = jwt.getClaim("roles");
		System.out.println("CLAIM: " + claim);
		if (claim.isNull() || claim.isMissing())
			return "";

		return claim.asString();
	}
}
