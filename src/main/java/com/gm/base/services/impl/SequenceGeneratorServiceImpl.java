package com.gm.base.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gm.base.entities.DatabaseSequence;
import com.gm.base.repositories.DatabaseSequenceRepository;
import com.gm.base.services.SequenceGeneratorService;

@Service
public class SequenceGeneratorServiceImpl implements SequenceGeneratorService{

	@Autowired
	DatabaseSequenceRepository databaseSequenceRepository;
	
	@Override
	public int generateSequence(String seqName) {
		DatabaseSequence databaseSequence;
		int returnValue;
		Optional<DatabaseSequence> optional = databaseSequenceRepository.findById(seqName);
		if(!optional.isPresent()) {
			databaseSequence = new DatabaseSequence();
			databaseSequence.setId(seqName);
			databaseSequence.setSeq(1);
			returnValue = 1; 
		}else {
			databaseSequence = optional.get();
			returnValue = databaseSequence.getSeq(); 
		}
		databaseSequence.setSeq(returnValue+1);
		databaseSequenceRepository.save(databaseSequence);
		
		return returnValue;
	}

}
