package com.coderscampus.api.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.api.domain.FarmDetails;
import com.coderscampus.api.domain.User;
import com.coderscampus.api.repository.FarmDetailsRepository;
import com.coderscampus.api.repository.FarmRegisterRepository;

@RestController
@CrossOrigin(origins="*")
//@CrossOrigin(origins = "https://final-client-production.up.railway.app")
public class FarmDetailsController {
	
	@Autowired
	private FarmDetailsRepository repository;
	
	@Autowired
	private FarmRegisterRepository farmRegisterRepository;
	@PostMapping("/send-details")
	public ResponseEntity <FarmDetails> sendDetails(@RequestBody FarmDetails details){
		FarmDetails newDetails = new FarmDetails();
		System.out.println(details);
		BeanUtils.copyProperties(details, newDetails);
		User foundUser = farmRegisterRepository.findById(details.getUserId()).get();
		FarmDetails foundFarmDetails = repository.findFarmDetailsByFarmName(details.getFarmName());
		
		System.out.println("Found-User: " + foundUser);
		if(foundFarmDetails == null) {
			
			foundUser.setFarmDetails(newDetails);
			newDetails.setUser(foundUser);
			repository.save(newDetails);
		} else {
			foundFarmDetails.setApple(details.getApple());
			foundFarmDetails.setBeef(details.getBeef());
			foundFarmDetails.setBlueberry(details.getBlueberry());
			foundFarmDetails.setBroccoli(details.getBroccoli());
			foundFarmDetails.setButter(details.getButter());
			foundFarmDetails.setCarrot(details.getCarrot());
			foundFarmDetails.setCorn(details.getCorn());
			foundFarmDetails.setCream(details.getCream());
			foundFarmDetails.setEgg(details.getEgg());
			foundFarmDetails.setMilk(details.getMilk());
			foundFarmDetails.setMutton(details.getMutton());
			foundFarmDetails.setPear(details.getPear());
			foundFarmDetails.setPork(details.getPork());
			foundFarmDetails.setStrawberry(details.getStrawberry());
			foundFarmDetails.setTomato(details.getTomato());
			foundFarmDetails.setPoultry(details.getPoultry());
			
			repository.save(foundFarmDetails);
		}
		
		return ResponseEntity.ok(newDetails);
		
		
	}
	@GetMapping("/get-details")
	public ResponseEntity <List<FarmDetails>> sendDetails(){
		System.out.println("dogpooperation");
		
		List<FarmDetails> list = repository.findAll();
		return ResponseEntity.ok(list);
		
	}
	


	
	
	
}
