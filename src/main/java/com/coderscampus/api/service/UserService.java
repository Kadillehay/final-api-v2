package com.coderscampus.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.api.domain.User;
import com.coderscampus.api.repository.FarmRegisterRepository;

@Service
public class UserService {
	
	@Autowired
	FarmRegisterRepository farmRegisterRepository;

	public User getUserById(Long id) {
	return farmRegisterRepository.findById(id).get();
		
	}
	
	

}
