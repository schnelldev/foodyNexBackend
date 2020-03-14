package com.gm.base.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gm.base.entities.Vendor;
import com.gm.base.repositories.VendorRepository;
import com.gm.base.services.SequenceGeneratorService;

@RestController
@RequestMapping("api/vendors")
@CrossOrigin
public class VendorController {
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	VendorRepository vendorRepository;
	
	@PostMapping
	public int post(@RequestBody Vendor vendor) {
		
		vendor.setVendorId(sequenceGeneratorService.generateSequence(Vendor.SEQUENCE_NAME));
		vendorRepository.save(vendor);
		return vendor.getVendorId();
	}
	
	
	@GetMapping
	public List<Vendor> getVendors(){
		return vendorRepository.findAll();
	}
	
}
