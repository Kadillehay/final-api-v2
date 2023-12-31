package com.coderscampus.api.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.api.domain.User;
import com.coderscampus.api.models.UserModel;
import com.coderscampus.api.repository.FarmRegisterRepository;

@RestController
@CrossOrigin(origins = "*")
public class DashboardController {

	@Autowired
	FarmRegisterRepository farmRegisterRepo;

	// Ogul I just copied this from the register, I assume the logic is the same?
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
		System.out.println(user);
		User foundUser = farmRegisterRepo.findUserByEmailAndPassword(user.getOriginalEmail(), user.getOriginalPassword());
		User updatedUser = null;
		if(foundUser.getEmailAddress() != null) {
			
	
			foundUser.setFarmName(user.getFarmName());
			foundUser.setEmailAddress(user.getEmailAddress());
			foundUser.setPassword(user.getPassword());
			foundUser.setPhoneNumber(user.getPhoneNumber());
			updatedUser = farmRegisterRepo.save(foundUser);
		}

		return ResponseEntity.ok(updatedUser);
	}
}
