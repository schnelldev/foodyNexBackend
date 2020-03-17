package com.gm.base.controllers;

import java.util.Date;
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

import com.gm.base.entities.ProductType;
import com.gm.base.repositories.ProductTypeRepository;
import com.gm.base.services.SequenceGeneratorService;

@RestController
@RequestMapping("/api/productType")
@CrossOrigin
public class ProductTypeController {
	
	@Autowired
	ProductTypeRepository productTypeRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService; 
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void add(@RequestBody ProductType productType) {
		productType.setProductTypeId(sequenceGeneratorService.generateSequence(ProductType.SEQUENCE_NAME));
		productType.setCreatedDate(new Date());
		productType.setUpdatedDate(new Date());
		productTypeRepository.save(productType);
	}
	
	@GetMapping("/clientId/{clientId}")
	public List<ProductType> getAll(@PathVariable String clientId){
		return productTypeRepository.findByClientId(clientId);
	}
	
	@GetMapping("/{id}")
	public ProductType get(@PathVariable Integer id){
		if(productTypeRepository.findById(id).isPresent()) {
			return productTypeRepository.findById(id).get();
		}else return null ;
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable Integer id,@RequestBody ProductType productType) {
		
		Optional<ProductType> optional = productTypeRepository.findById(id);
		if(optional.isPresent()) {
			ProductType productTypeEdit = optional.get();
			productType.setProductTypeId(productTypeEdit.getProductTypeId());
			productType.setCreatedDate(productTypeEdit.getCreatedDate());
			productType.setUpdatedDate(new Date());
			productTypeRepository.save(productType);
			return "success";
		}else return "entity not found";
		
	}
	
	
	@PutMapping("/{id}/status/{status}")
	public String activate(@PathVariable Integer id, @PathVariable String status) {
		
		if(status.equals("activate") || status.equals("deactivate")) {
			Optional<ProductType> optional = productTypeRepository.findById(id);
			if(optional.isPresent()) {
				ProductType productType = optional.get();
				productType.setActive(status.equals("activate")?true : false);
				productType.setUpdatedDate(new Date());
				productTypeRepository.save(productType);
			}else return "entity not found";
		}else return "invalid status";
		
		return "success";
	}
}
