package com.gm.base.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gm.base.entities.Member;
import com.gm.base.entities.Staff;
import com.gm.base.entities.Trainer;
import com.gm.base.entities.User;
import com.gm.base.repositories.MemberRepository;
import com.gm.base.repositories.StaffRepository;
import com.gm.base.repositories.TrainerRepository;
import com.gm.base.repositories.UserRepository;
import com.gm.base.vo.ErrorVO;
import com.gm.base.vo.LoginVO;

@RestController
@RequestMapping("api/login")
@CrossOrigin
public class LoginController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	TrainerRepository trainerRepository;
	
	@Autowired
	StaffRepository staffRepository;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder bcrypt;
	
	@PostMapping
	public ResponseEntity<?> login(@RequestBody LoginVO loginVO) {
		Optional<Member> optionalMember = memberRepository.findById(loginVO.getUserName());
		Optional<Trainer> optionalTrainer = trainerRepository.findById(loginVO.getUserName());
		Optional<Staff> optionalStaff = staffRepository.findById(loginVO.getUserName());
		Optional<User> optionalAdmin = userRepository.findById(loginVO.getUserName());
		User user = null;
		if(optionalMember.isPresent()) {
			user =  optionalMember.get();
		}else if(optionalTrainer.isPresent()) {
			user =  optionalTrainer.get();
		}else if(optionalStaff.isPresent()) {
			user =  optionalStaff.get();
		}else if(optionalAdmin.isPresent()) {
			user = optionalAdmin.get();
		}
		if (user != null /*&& user.getClientId().equals(loginVO.getClientId())*/) {
			 
			if (bcrypt.matches(loginVO.getPassword(), user.getHashedPassword())) {
				loginVO.setUserType(user.getUserType());
				return new ResponseEntity<>(loginVO,HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ErrorVO("Password Do Not Match", "pwderr"),HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<>(new ErrorVO("User Not Found", "usernotfounderr"),HttpStatus.OK);
		}
	} 
}