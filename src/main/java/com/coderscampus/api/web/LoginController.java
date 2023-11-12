package com.coderscampus.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.api.models.UserModel;
import com.coderscampus.api.repository.FarmRegisterRepository;
import com.coderscampus.api.security.FarmUserDetails;
import com.coderscampus.api.security.jwt.JwtIssuer;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
	@Autowired
	FarmRegisterRepository farmRegisterRepo;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	private JwtIssuer jwtIssuer;

	@PostMapping("/login")

	public ResponseEntity<String> login(@RequestBody @Validated UserModel user) throws Exception {

		var authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getEmailAddress(), user.getPassword()));
		
		var principal = (FarmUserDetails) authentication.getPrincipal();
		var roles = principal.getAuthorities().stream().map(GrantedAuthority::getAuthority).toString();
		var token = jwtIssuer.issue(principal.getUserId(), principal.getUsername(), roles);

		
		return ResponseEntity.ok(token);
	}

}
