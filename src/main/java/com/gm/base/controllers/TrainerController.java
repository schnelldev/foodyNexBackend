package com.gm.base.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gm.base.entities.Client;
import com.gm.base.entities.Trainer;
import com.gm.base.entities.User;
import com.gm.base.enums.UserType;
import com.gm.base.repositories.ClientRepository;
import com.gm.base.repositories.TrainerRepository;
import com.gm.base.services.SequenceGeneratorService;

@RestController
@RequestMapping("api/trainers")
@CrossOrigin
public class TrainerController {

	@Autowired
	TrainerRepository trainerRepository;

	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	@Autowired
	ClientRepository clientSeqPrefixRepository;

	@Autowired
	BCryptPasswordEncoder encoder;

	@Value("${gm.default.password}")
	private String defaultPassword;

	@Value("${gm.images.path}")
	private String imageFolder;
	
	private static final String TRAINER_PATH = "/trainer/";
	
	private final static String DEFAULT_FILE_PATH = "/default/default.png";

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addNewEntity(@RequestBody Trainer trainer) {
		Optional<Client> optional = clientSeqPrefixRepository.findById(trainer.getClientId());
		String userId = "";
		if (optional.isPresent()) {
			String prefixStr = optional.get().getPrefixString();
			userId = prefixStr + "T"
					+ sequenceGeneratorService.generateSequence(trainer.getClientId() + User.TRAINER_SEQUENCE_NAME);
			trainer.setUserId(userId);
			trainer.setHashedPassword(encoder.encode(defaultPassword));
			trainer.setUserType(UserType.TRAINER);
			trainerRepository.save(trainer);
		}
		return userId;
	}
	
	@GetMapping("/{id}")
	public Trainer findById(@PathVariable String id) {
		Optional<Trainer> optional = trainerRepository.findById(id);
		Trainer t = null;
		if(optional.isPresent()) {
			t = optional.get();
		}
		return t;
	}

	@PutMapping("/{id}/specialization/add/{specialization}")
	public void addSpecialization(@PathVariable String id, @PathVariable String specialization) {
		Trainer trainer;
		Optional<Trainer> optional = trainerRepository.findById(id);
		if (optional.isPresent()) {
			trainer = optional.get();
			List<String> specializations = trainer.getSpecializations();
			specializations.add(specialization);
			trainer.setSpecializations(specializations);
			trainerRepository.save(trainer);
		}
	}

	@PutMapping("/{id}/specialization/remove/{specialization}")
	public void removeSpecialization(@PathVariable String id, @PathVariable String specialization) {
		Trainer trainer;
		Optional<Trainer> optional = trainerRepository.findById(id);
		if (optional.isPresent()) {
			trainer = optional.get();
			List<String> specializations = trainer.getSpecializations();
			specializations.remove(specialization);
			trainer.setSpecializations(specializations);
			trainerRepository.save(trainer);
		}
	}

	@GetMapping("/clientId/{clientId}")
	public List<Trainer> getAll(@PathVariable String clientId) {
		return trainerRepository.findByClientId(clientId);
	}

	@PostMapping("/{id}/photo")
	public String singleFileUpload(@PathVariable String id, @RequestParam("photo") MultipartFile photo)
			throws IOException {
		String destination = imageFolder + TRAINER_PATH + id;
		File file = new File(destination);
		if (!file.exists()) {
			file.mkdirs();
		}
		String trainerPhoto = imageFolder + TRAINER_PATH + id + "/profile.png";
		File trainerPhotoFile = new File(trainerPhoto);
		if (photo.getOriginalFilename().endsWith("png")) {
			photo.transferTo(trainerPhotoFile);
		}
		return photo.getName();
	}

	@GetMapping(value = "/{id}/profilePhoto", produces = MediaType.IMAGE_PNG_VALUE)
	public void getImage(@PathVariable String id, HttpServletResponse response) throws IOException {
		File imgFile = new File(imageFolder + TRAINER_PATH + id + "/profile.png");
		File defaultImageFile = new File(imageFolder + DEFAULT_FILE_PATH);
		try(InputStream is = new FileInputStream(imgFile)){
		response.setContentType(MediaType.IMAGE_PNG_VALUE);
		StreamUtils.copy(is, response.getOutputStream());
		}catch(FileNotFoundException fnfe) {
			try(InputStream is = new FileInputStream(defaultImageFile)){
				response.setContentType(MediaType.IMAGE_PNG_VALUE);
		        StreamUtils.copy(is, response.getOutputStream());
			}
		}
	}
}
