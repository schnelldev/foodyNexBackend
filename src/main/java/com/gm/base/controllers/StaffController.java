package com.gm.base.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StreamUtils;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gm.base.entities.ClientSeqPrefix;
import com.gm.base.entities.Staff;
import com.gm.base.entities.User;
import com.gm.base.enums.UserType;
import com.gm.base.repositories.ClientSeqPrefixRepository;
import com.gm.base.repositories.StaffRepository;
import com.gm.base.services.SequenceGeneratorService;

@RestController
@RequestMapping("api/staffs")
@CrossOrigin
public class StaffController {
	
	@Autowired
	StaffRepository staffRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	ClientSeqPrefixRepository clientSeqPrefixRepository; 
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Value("${gm.default.password}")
	private String defaultPassword;
	
	@Value("${gm.images.path}")
	private String imageFolder;
	
	private static final String STAFF_PATH = "/staff/";
	
	private final static String DEFAULT_FILE_PATH = "/default/default.png";
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addNewEntity(@RequestBody Staff staff) {
		Optional<ClientSeqPrefix> optional = clientSeqPrefixRepository.findById(staff.getClientId());
		if(optional.isPresent()) {
			String prefixStr = optional.get().getPrefixString();
			staff.setUserId(prefixStr+"S"+sequenceGeneratorService.generateSequence(staff.getClientId()+User.STAFF_SEQUENCE_NAME));
			staff.setHashedPassword(encoder.encode(defaultPassword));
			staff.setUserType(UserType.STAFF);
			staffRepository.save(staff);
		}
	}
	
	@GetMapping("/clientId/{clientId}")
	public List<Staff> getAll(@PathVariable String clientId) {
		return staffRepository.findByClientId(clientId);
	}
	
	@GetMapping("/{id}")
	public Staff getOne(@PathVariable String id) {
		 Optional<Staff> optional = staffRepository.findById(id);
		 if(optional.isPresent()) {
			 return optional.get();
		 }else {
			 return null;
		 }
	}
	
	@PostMapping("/{id}/photo")
	public String singleFileUpload(@PathVariable String id, @RequestParam("photo") MultipartFile photo)
			throws IOException {
		String destination = imageFolder + STAFF_PATH + id;
		File file = new File(destination);
		if (!file.exists()) {
			file.mkdirs();
		}
		String staffPhoto = imageFolder + STAFF_PATH + id + "/profile.png";
		File staffPhotoFile = new File(staffPhoto);
		if (photo.getOriginalFilename().endsWith("png")) {
			photo.transferTo(staffPhotoFile);
		}
		return photo.getName();
	}

	@GetMapping(value = "/{id}/profilePhoto", produces = MediaType.IMAGE_PNG_VALUE)
	public void getImage(@PathVariable String id, HttpServletResponse response) throws IOException {
		File imgFile = new File(imageFolder + STAFF_PATH + id + "/profile.png");
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
