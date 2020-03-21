package com.gm.base.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gm.base.entities.Client;
import com.gm.base.repositories.ClientRepository;

@RestController
@RequestMapping("api/clients")
@CrossOrigin
public class ClientController {
	
	@Autowired
	ClientRepository clientSeqPrefixRepository;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Value("${gm.client.password}")
	private String clientPassword;
	
	@GetMapping()
	public List<Client> getAll(){
		return clientSeqPrefixRepository.findAll();
	}
	
	
	@PostMapping
	public String post(@RequestBody Client clientSeqPrefix) {
		
		if(!clientSeqPrefixRepository.existsById(clientSeqPrefix.getClientId())) {
			clientSeqPrefix.setHashedPassword(encoder.encode(clientPassword));
			clientSeqPrefixRepository.save(clientSeqPrefix);
			return "success";
		}
		else
			return "client already exists";

	}
	
}
