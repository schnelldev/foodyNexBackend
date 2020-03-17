package com.gm.base.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gm.base.entities.Product;
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
	
	
	@PutMapping("/{id}")
	public String update(@PathVariable Integer id,@RequestBody Vendor vendor) {
		
		Optional<Vendor> optional = vendorRepository.findById(id);
		if(optional.isPresent()) {
			Vendor vendorEdit = optional.get();
			vendor.setVendorId(vendorEdit.getVendorId());
			vendorRepository.save(vendor);
			return "success";
		}else return "entity not found";	
	}
	
}
