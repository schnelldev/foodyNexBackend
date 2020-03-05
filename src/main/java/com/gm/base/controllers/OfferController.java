package com.gm.base.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gm.base.entities.Offer;
import com.gm.base.repositories.OfferRepository;
import com.gm.base.services.SequenceGeneratorService;

@RestController
@RequestMapping("api/offers")
@CrossOrigin
public class OfferController {
	
	@Autowired
	OfferRepository offerRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService; 
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void add(@RequestBody Offer offer) {
		offer.setOfferId(sequenceGeneratorService.generateSequence(Offer.SEQUENCE_NAME));
		offerRepository.save(offer);
	}
	
	@GetMapping("/clientId/{clientId}")
	public List<Offer> getAll(@PathVariable String clientId){
		return offerRepository.findByClientId(clientId);
	}
	
	@GetMapping("/{id}")
	public Offer get(@PathVariable Integer id){
		if(offerRepository.findById(id).isPresent()) {
			return offerRepository.findById(id).get();
		}else return null ;
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable Integer id,@RequestBody Offer offer) {
		
		Optional<Offer> optional = offerRepository.findById(id);
		if(optional.isPresent()) {
			Offer offerEdit = optional.get();
			offer.setOfferId(offerEdit.getOfferId());
			offerRepository.save(offer);
			return "success";
		}else return "entity not found";
		
	}
}
