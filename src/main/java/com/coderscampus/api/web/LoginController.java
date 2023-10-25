package com.coderscampus.api.web;

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
public class LoginController {
	@Autowired
	FarmRegisterRepository farmRegisterRepo;
	

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody UserModel user) {
		User foundUser = farmRegisterRepo.findUserByEmailAndPassword(user.getEmailAddress(), user.getPassword());
		System.out.println(foundUser);
		if (foundUser != null) {
			return ResponseEntity.ok(foundUser);
		}
		return null;

	}

}
