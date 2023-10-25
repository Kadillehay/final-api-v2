package com.coderscampus.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.api.domain.FarmDetails;
import com.coderscampus.api.domain.User;
import com.coderscampus.api.repository.FarmDetailsRepository;
import com.coderscampus.api.repository.FarmRegisterRepository;

@RestController
@CrossOrigin(origins="*")
public class AdminController {

	
	@Autowired
	private FarmDetailsRepository repo;
	
	@Autowired
	private FarmRegisterRepository registerRepo;
	
	@PostMapping("/get-user-farm-details")
	public ResponseEntity<FarmDetails> getFarmDetails(@RequestBody Long userId) {
		System.out.println(userId);
		User user = registerRepo.findById(userId).get();
		FarmDetails details = repo.findByUser(user);
		
		return ResponseEntity.ok(details);
	}
}
