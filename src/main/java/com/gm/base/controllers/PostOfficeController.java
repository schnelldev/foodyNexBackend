package com.gm.base.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gm.base.entities.PostOffice;
import com.gm.base.repositories.PostOfficeRepository;
import com.gm.base.services.SequenceGeneratorService;

@RestController
@RequestMapping("api/pos")
@CrossOrigin
public class PostOfficeController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	PostOfficeRepository postOfficeRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	@GetMapping
	public void getAll() {
		postOfficeRepository.deleteAll();
		for(int pincode= 100000; pincode<999999;pincode++) {
			System.out.println(pincode);
			List<LinkedHashMap<String, Object>> response = restTemplate.getForObject(
				  "https://api.postalpincode.in/pincode/" + pincode,List.class);
				if(response.size()>0) {
					//System.out.println(response.get(0).get("Message"));
					//System.out.println(response.get(0).get("Status"));
					
					if(response.get(0).get("Status").equals("Success")?true :false) {
						for(Object o :(List)response.get(0).get("PostOffice")) {
							Map<String, Object> map = (Map)o;
							System.out.println(map.get("Name"));
							System.out.println(map.get("Circle"));
							System.out.println(map.get("District"));
							System.out.println(map.get("Pincode"));
							System.out.println(map.get("Name"));
							PostOffice postOffice = new PostOffice();
							
							postOffice.setPostOfficeId(sequenceGeneratorService.generateSequence(PostOffice.SEQUENCE_NAME));
							postOffice.setName((String)map.get("Name"));
							postOffice.setDistrict((String)map.get("District"));
							postOffice.setCircle((String)map.get("Circle"));
							postOffice.setState((String)map.get("State"));
							postOffice.setPincode((String)map.get("Pincode"));
							
							postOfficeRepository.save(postOffice);
						}
					}
				}
		}
	}
}
