package com.gm.base.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gm.base.entities.MembershipPackage;
import com.gm.base.repositories.MembershipPackageRepository;
import com.gm.base.services.SequenceGeneratorService;

@RestController
@RequestMapping("api/membershipPackages")
@CrossOrigin
public class MembershipPackageController {

	@Autowired
	MembershipPackageRepository membershipPackageRepository;

	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void add(@RequestBody MembershipPackage membershipPackage) {
		membershipPackage
				.setMembershipPackageId(sequenceGeneratorService.generateSequence(MembershipPackage.SEQUENCE_NAME));
		membershipPackageRepository.save(membershipPackage);
	}

	@GetMapping("/clientId/{clientId}")
	public List<MembershipPackage> getAll(@PathVariable String clientId) {
		return membershipPackageRepository.findByClientId(clientId);
	}

	@GetMapping("/{id}")
	public MembershipPackage findOne(@PathVariable Integer id) {
		Optional<MembershipPackage> optional = membershipPackageRepository.findById(id);
		MembershipPackage membershipPackage = null;
		if (optional.isPresent()) {
			membershipPackage = optional.get();
		}
		return membershipPackage;
	}
}
