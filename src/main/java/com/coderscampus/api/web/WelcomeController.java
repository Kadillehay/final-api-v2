package com.coderscampus.api.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.api.domain.User;

@RestController
@CrossOrigin(origins="*")
public class WelcomeController {

	@GetMapping ("/welcome")
	public ResponseEntity<User> welcome() {

		User farm = new User();
		farm.setName("PhinFarm");
		farm.setProduct("vergible");
		
		return ResponseEntity.ok(farm);

	}

}
