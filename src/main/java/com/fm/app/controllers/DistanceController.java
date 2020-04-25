package com.fm.app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fm.app.entities.Client;
import com.fm.app.repositories.ClientRepository;
import com.fm.app.util.DistanceUtil;

@RestController
@RequestMapping("/api/distance")
public class DistanceController {

	@Autowired
	ClientRepository clientRepository;
	
	@GetMapping
	public double distance(@RequestParam int clientId,@RequestParam double latitude,@RequestParam double longitude) {
		double result = 99.99;
		Optional<Client> optional = clientRepository.findById(clientId);
		if(optional.isPresent()) {
			result = DistanceUtil.getDistance(optional.get(), latitude, longitude); 
		}
		return result;
	}
}
