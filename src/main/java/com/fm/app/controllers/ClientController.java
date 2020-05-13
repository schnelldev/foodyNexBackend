package com.fm.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fm.app.entities.Client;
import com.fm.app.repositories.ClientRepository;
import com.fm.app.services.FirebaseService;
import com.fm.app.services.SequenceGeneratorService;

@RestController
@RequestMapping("api/clients")
@CrossOrigin
public class ClientController {
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	FirebaseService firebaseService;
	
	@Value("${fm.client.password}")
	private String clientPassword;
	
	@PostMapping
	public String addClient(@RequestBody Client client) {
		client.setClientId(sequenceGeneratorService.generateSequence(Client.SEQUENCE_NAME));
		client.setHashedPassword(encoder.encode(clientPassword));
		String uid = firebaseService.addUserToFirebase(client,clientPassword);
		client.setFirebaseId(uid);
		client = clientRepository.save(client);
		return "success";
	}
	
	@PostMapping("/{id}/lat-long/lat/{lat}/long/{longitude}")
	public String addLatLong(@PathVariable Integer id , @PathVariable double lat, @PathVariable double longitude) {
		Optional<Client> optional = clientRepository.findById(id);
		if(optional.isPresent()) {
			Client client = optional.get();
			client.setLatitude(lat);
			client.setLongitude(longitude);
			clientRepository.save(client);
			return "success";
		}else {
			return "Client not found";
		}
	}
	
	@GetMapping
	public List<Client> getAll() {
		return clientRepository.findAll();
	}

}
