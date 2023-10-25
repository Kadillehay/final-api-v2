package com.coderscampus.api.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.api.domain.User;
import com.coderscampus.api.repository.FarmRegisterRepository;
import com.coderscampus.api.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class FarmRegistryController {
	
	@Autowired
	FarmRegisterRepository farmRegisterRepo; 
	@Autowired
	UserService userService;


	
	@PostMapping("/register")
	public ResponseEntity<Map<String, User >> submitRegister(@RequestBody User farmRegistry) {
		User user = new User();
		BeanUtils.copyProperties(farmRegistry, user);
		
		
		
		User registered = farmRegisterRepo.save(user);
		return ResponseEntity.ok(Map.of("id", registered));
	}
	@PostMapping("/get-user")
	public ResponseEntity<User> getUser(@RequestBody Long id){
		return ResponseEntity.ok(userService.getUserById(id));
	
		
	}
	

	
}
