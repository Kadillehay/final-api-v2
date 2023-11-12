package com.coderscampus.api.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;

import com.coderscampus.api.security.FarmUserDetails;

public class FarmUserDetailsAuthToken extends AbstractAuthenticationToken {

	@Autowired
	private FarmUserDetails farmUserDetails;
	
	public FarmUserDetailsAuthToken(FarmUserDetails farmUserDetails) {
		super(farmUserDetails.getAuthorities());
		System.out.println("FARM USER DETAILS: " +  farmUserDetails);
		this.farmUserDetails = farmUserDetails;
		setAuthenticated(true);
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return farmUserDetails;
	}

}
