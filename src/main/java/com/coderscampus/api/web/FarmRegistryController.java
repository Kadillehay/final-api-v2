package com.coderscampus.api.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.api.domain.User;
import com.coderscampus.api.repository.FarmRegisterRepository;
import com.coderscampus.api.security.jwt.JwtIssuer;
import com.coderscampus.api.service.UserService;

@RestController
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "https://final-client-production.up.railway.app")
public class FarmRegistryController {
	
	@Autowired
	FarmRegisterRepository farmRegisterRepo; 
	@Autowired
	UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtIssuer jwtIssuer;
	
	@PostMapping("/register")
	public ResponseEntity<String> submitRegister(@RequestBody User farmRegistry) {
		User user = new User();
		BeanUtils.copyProperties(farmRegistry, user);
		
		// Set role as well as ROLE_USER
		user.setPassword(passwordEncoder.encode(farmRegistry.getPassword()));
		user.setRoles("ROLE_USER");
		user.setOriginalPassword(farmRegistry.getPassword());
		User registered = farmRegisterRepo.save(user);
		var token = jwtIssuer.issue(registered.getUserId(), registered.getEmailAddress(), "ROLE_USER");
//		return ResponseEntity.ok(Map.of("id", registered));
		return ResponseEntity.ok(token);
	}
	@PostMapping("/get-user")
	public ResponseEntity<User> getUser(@RequestBody Long id){
		return ResponseEntity.ok(userService.getUserById(id));
	
		
	}
	

	
}
