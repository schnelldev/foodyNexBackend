package com.gm.base.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gm.base.entities.Guideline;
import com.gm.base.repositories.guidelineRepository;

@RestController
@RequestMapping("/api/guidelines")
@CrossOrigin
public class GuidelineController {
	
	
	@Autowired
	guidelineRepository guidelineRepository;
	
	@GetMapping
	public List<Guideline> get(){
		return guidelineRepository.findAll();
	}
	
	@PutMapping("/{id}")
	public String put(@PathVariable Integer id) {
		
		
		
		if(guidelineRepository.count() == 0) {
			return "zero";
		}
		return "not zero";
	}
}
