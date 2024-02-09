package com.coderscampus.api.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.api.domain.User;

@RestController
//@CrossOrigin(origins="*")
@CrossOrigin(origins = "https://final-client-production.up.railway.app")
public class WelcomeController {

	@GetMapping ("/welcome")
	public ResponseEntity<User> welcome() {

		User farm = new User();
		farm.setName("PhinFarm");
		farm.setProduct("vergible");
		
		return ResponseEntity.ok(farm);

	}
	
	@GetMapping("/")
	public String getHome() {
		return "Hello Home";
	}

}
