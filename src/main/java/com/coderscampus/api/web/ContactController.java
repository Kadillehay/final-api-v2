package com.coderscampus.api.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.api.domain.ContactMessage;
import com.coderscampus.api.repository.ContactMessageRepository;

@RestController
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "https://final-client-production.up.railway.app")
public class ContactController {

	@Autowired
	private ContactMessageRepository contactMessageRepo;

	@PostMapping("/contact")
	public ResponseEntity<ContactMessage> submitContactForm(@RequestBody ContactMessage contactMessage) {
		System.out.println("running");
		ContactMessage savedMessage = contactMessageRepo.save(contactMessage);
		return ResponseEntity.ok(savedMessage);
	}

	@GetMapping("/admin-contact")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<ContactMessage>> getContactMessages() {
		System.out.println("getContactMessages");
		List<ContactMessage> messages = contactMessageRepo.findAll();
		return ResponseEntity.ok(messages);
	}

}
