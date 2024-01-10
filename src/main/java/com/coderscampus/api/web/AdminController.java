package com.coderscampus.api.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.api.domain.FarmDetails;
import com.coderscampus.api.domain.User;
import com.coderscampus.api.models.UserModel;
import com.coderscampus.api.repository.FarmDetailsRepository;
import com.coderscampus.api.repository.FarmRegisterRepository;

@RestController
@CrossOrigin(origins="*")
public class AdminController {

	
	@Autowired
	private FarmDetailsRepository repo;
	
	@Autowired
	private FarmRegisterRepository registerRepo;
	
	@Autowired
	AuthenticationManager authenticationManager;
	@PostMapping("/get-user-farm-details")
	public ResponseEntity<FarmDetails> getFarmDetails(@RequestBody Long userId) {
		User user = registerRepo.findById(userId).get();
		FarmDetails details = repo.findByUser(user);
		
		return ResponseEntity.ok(details);
	}
	
	@GetMapping("/admin-dashboard")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Map<String, Boolean>> getAdminDashboard(UserModel user) throws Exception {
		return ResponseEntity.ok(Map.of("isAdmin", true));
	}
	
	@GetMapping("/logged")
	 public UserDetails getLoggedInUserDetails(){
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        System.out.println("LOGGED: " + authentication);
	        if(authentication != null && authentication.getPrincipal() instanceof UserDetails){
	            return (UserDetails) authentication.getPrincipal();
	        }
	        return null;
	    }
	@GetMapping("/get-all-farms")
	public ResponseEntity<List<FarmDetails>> getAllFarms() {
		System.out.println("Running");
		return ResponseEntity.ok(repo.findAll());
	}
	@GetMapping("/user-info")
   public ResponseEntity<List<User>> getUserInfo() {
		return ResponseEntity.ok(registerRepo.findAll());
	}
}
