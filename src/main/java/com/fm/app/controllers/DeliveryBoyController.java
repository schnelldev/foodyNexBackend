package com.fm.app.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fm.app.entities.DeliveryBoy;
import com.fm.app.repositories.DeliveryBoyRepository;
import com.fm.app.services.SequenceGeneratorService;
import com.fm.app.vo.DeliveryBoyLoginVO;
import com.fm.app.vo.DeliveryBoyVO;

@RestController
@RequestMapping("api/deliveryBoys")
@CrossOrigin
public class DeliveryBoyController {
	
	@Autowired
	DeliveryBoyRepository deliveryBoyRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@PostMapping
	public ResponseEntity<Object> addDeliveryBoy(@RequestBody DeliveryBoyVO deliveryBoyVO){
		try {
			if(!deliveryBoyRepository.findByUserName(deliveryBoyVO.getUserName()).isPresent()) {
				DeliveryBoy deliveryBoy = new DeliveryBoy();
				deliveryBoy.setId(sequenceGeneratorService.generateSequence(DeliveryBoy.SEQUENCE_NAME));
				deliveryBoy.setFullName(deliveryBoyVO.getFullName());
				deliveryBoy.setUserName(deliveryBoyVO.getUserName());
				deliveryBoy.setHashedPassword(encoder.encode(deliveryBoyVO.getPassword()));
				deliveryBoy.setCreationDate(new Date());
				deliveryBoy = deliveryBoyRepository.save(deliveryBoy);
				return ResponseEntity.ok("success");
			}else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("user already exists");
			}
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping
	public List<DeliveryBoy> getAllDeliveryBoys(){
		return deliveryBoyRepository.findAll();
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> addDeliveryBoy(@RequestBody DeliveryBoyLoginVO loginVO){
		if(loginVO!=null && !loginVO.getUserName().isEmpty() && !loginVO.getPassword().isEmpty()) {
			Optional<DeliveryBoy> optional = deliveryBoyRepository.findByUserName(loginVO.getUserName());
			if(optional.isPresent()) {
				if(encoder.matches(loginVO.getPassword(), optional.get().getHashedPassword())) {
					return ResponseEntity.ok("success");
				}else {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("invalid_password");
				}
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("username_not_found");
			}
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("bad_request");
		}
	}
}
