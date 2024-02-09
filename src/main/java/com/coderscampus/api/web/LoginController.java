package com.coderscampus.api.web;

import java.util.Collection;
import java.util.stream.Collectors;

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
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "https://final-client-production.up.railway.app")
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
		
		String authorities = principal.getAuthorities().stream()
				.map(Object::toString)
				.collect(Collectors.joining(", "));
		
//		var roles = authorities.stream().map(GrantedAuthority::getAuthority).toString();
		var token = jwtIssuer.issue(principal.getUserId(), principal.getUsername(), authorities);

		
		return ResponseEntity.ok(token);
	}

}
