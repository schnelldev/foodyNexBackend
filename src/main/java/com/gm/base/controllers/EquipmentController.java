package com.gm.base.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gm.base.entities.Equipment;
import com.gm.base.repositories.EquipmentRepository;
import com.gm.base.services.SequenceGeneratorService;

@RestController
@RequestMapping("api/equipments")
@CrossOrigin
public class EquipmentController {

	@Autowired
	EquipmentRepository equipmentRepository;

	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addNewEntity(@RequestBody Equipment equipment) {
		equipment.setEquipmentId(sequenceGeneratorService.generateSequence(Equipment.SEQUENCE_NAME));
		equipmentRepository.save(equipment);
		return "success";
	}

	@GetMapping("/clientId/{clientId}")
	public List<Equipment> getAll(@PathVariable String clientId) {
		return equipmentRepository.findByClientId(clientId);
	}
}
