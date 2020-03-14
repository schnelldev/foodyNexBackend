package com.gm.base.controllers;

import java.util.ArrayDeque;
import java.util.Deque;
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

import com.gm.base.entities.GymnexClass;
import com.gm.base.entities.Plan;
import com.gm.base.repositories.PlanRepository;
import com.gm.base.services.SequenceGeneratorService;

@RestController
@RequestMapping("api/plans")
@CrossOrigin
public class PlanController {
	
	@Autowired
	PlanRepository planRepository;
	

	@Autowired
	SequenceGeneratorService sequenceGeneratorService; 
	
	@GetMapping
	public List<Plan> getAll() {
		return planRepository.findAll();
	}
	
	@PostMapping
	public Plan add(@RequestBody Plan plan) {
		plan.setPlanId(sequenceGeneratorService.generateSequence(Plan.SEQUENCE_NAME));
		return planRepository.save(plan);
	}
	
	@GetMapping("/clientId/{clientId}")
	public List<Plan> findAllByClientId(@PathVariable String clientId ){
		return planRepository.findByClientId(clientId);
	}
	
	
	@PutMapping("/{id}/class")
	public Plan addClass(@PathVariable Integer id, @RequestBody List<GymnexClass> c) {
		
		Optional<Plan> optional = planRepository.findById(id);
		
		Plan p = optional.get();
		System.out.println(p.availableClasses);
		p.setAvailableClasses(c);
		planRepository.save(p);
		return p;
		
//		if(optional.isPresent()) {
//			Deque<List<GymnexClass>> de_que = new ArrayDeque<List<GymnexClass>>();
//			
//			de_que.push(c);
//			return p;
//		}
//		else {
//			
//		}

	}
}
