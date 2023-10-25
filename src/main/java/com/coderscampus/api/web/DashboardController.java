//package com.coderscampus.api.web;
//
//import java.util.List;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.coderscampus.api.domain.User;
//import com.coderscampus.api.models.UserModel;
//import com.coderscampus.api.repository.FarmRegisterRepository;
//
//@RestController
//@CrossOrigin(origins = "*")
//public class DashboardController {
//	
//	@Autowired
//	FarmRegisterRepository farmRegisterRepo;
//	@Autowired
//	UserModel userModel;
//	
//	//Ogul I just copied this from the register, I assume the logic is the same?
//	@PostMapping("/user-dashboard")
//	public ResponseEntity<List<Object>> updateRegister(@RequestBody User farmRegistry) {
//		User user = new User();
//		BeanUtils.copyProperties(farmRegistry, user);
//		
//		User registered = farmRegisterRepo.save(user);
//		System.out.println("working?");
//		return ResponseEntity.ok(List.of(registered.getId(), registered.getFarmName()));
//	
//	}
//}
