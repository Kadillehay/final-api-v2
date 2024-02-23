package com.coderscampus.api.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.api.domain.User;
import com.coderscampus.api.models.UserModel;
import com.coderscampus.api.repository.FarmDetailsRepository;
import com.coderscampus.api.repository.FarmRegisterRepository;
import com.coderscampus.api.security.jwt.JwtDecoder;
import com.coderscampus.api.security.jwt.JwtToPrincipalConverter;

@RestController
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "https://final-client-production.up.railway.app")
public class DashboardController {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	FarmRegisterRepository farmRegisterRepo;
	@Autowired
	JwtDecoder jwtDecoder;
	
	@Autowired
	FarmDetailsRepository farmDetailsRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtToPrincipalConverter converter;


	@PostMapping("/user-dashboard")
	public ResponseEntity<List<Object>> updateRegister(@RequestBody User user) {
		System.out.println(user);
		User newUser = new User();
		BeanUtils.copyProperties(user, newUser);

		User registered = farmRegisterRepo.save(newUser);
		System.out.println("working?");
		return ResponseEntity.ok(List.of(registered.getId(), registered.getFarmName()));

	}

	@PostMapping("/update-user")
	public ResponseEntity<User> updateUser(@RequestBody UserModel user) {
		User foundUser = farmRegisterRepo.findUserByEmailAndPassword(user.getOriginalEmail(), user.getOriginalPassword());
		User updatedUser = null;
		if(foundUser.getEmailAddress() != null) {
			
	
			foundUser.setFarmName(user.getFarmName());
			foundUser.setEmailAddress(user.getEmailAddress());
			foundUser.setPassword(encoder.encode(user.getPassword()));
			foundUser.setPhoneNumber(user.getPhoneNumber());
			updatedUser = farmRegisterRepo.save(foundUser);
			
		}

		return ResponseEntity.ok(updatedUser);
	}
	
	@GetMapping("/get-farmer-details")
	public ResponseEntity<User> getFarmerDetails() {
		var user = SecurityContextHolder.getContext().getAuthentication().getName();
		
		return ResponseEntity.ok(farmRegisterRepo.findByEmailAddress(user).orElseThrow());
	}
}
