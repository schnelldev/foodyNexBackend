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

import com.gm.base.entities.Product;
import com.gm.base.repositories.ProductRepository;
import com.gm.base.services.SequenceGeneratorService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService; 
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void add(@RequestBody Product product) {
		product.setProductId(sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME));
		productRepository.save(product);
	}
	
	@GetMapping("/clientId/{clientId}")
	public List<Product> getAll(@PathVariable String clientId){
		return productRepository.findByClientId(clientId);
	}
	
	@GetMapping("/{id}")
	public Product get(@PathVariable Integer id){
		if(productRepository.findById(id).isPresent()) {
			return productRepository.findById(id).get();
		}else return null ;
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable Integer id,@RequestBody Product product) {
		
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isPresent()) {
			Product productEdit = optional.get();
			product.setProductId(productEdit.getProductId());
			productRepository.save(product);
			return "success";
		}else return "entity not found";
		
	}

}
