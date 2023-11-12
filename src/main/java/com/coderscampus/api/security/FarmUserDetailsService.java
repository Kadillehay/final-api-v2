package com.coderscampus.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coderscampus.api.repository.FarmRegisterRepository;

@Service
public class FarmUserDetailsService  implements UserDetailsService{

	
	@Autowired
	private  FarmRegisterRepository farmRegisterRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			
		return farmRegisterRepository.findByEmailAddress(username)
				.map(FarmUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("No user found"));
	}

}
