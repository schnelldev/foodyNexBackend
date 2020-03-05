package com.gm.base.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.gm.base.vo.ChangePasswordVO;

@RestController
@RequestMapping("api/changePassword")
@CrossOrigin
public class ChangePasswordController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	TrainerRepository trainerRepository;
	
	@Autowired
	StaffRepository staffRepository;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@PostMapping("/user/{id}")
	public String changeForMember(@PathVariable String id,@RequestBody ChangePasswordVO vo) {
		Optional<Member> optionalMember = memberRepository.findById(id);
		Optional<Trainer> optionalTrainer = trainerRepository.findById(id);
		Optional<Staff> optionalStaff = staffRepository.findById(id);
		User u = null;
		if(optionalMember.isPresent()) {
			u = optionalMember.get();
		}else if(optionalTrainer.isPresent()) {
			u = optionalTrainer.get();
		}else if(optionalStaff.isPresent()) {
			u = optionalStaff.get();
		}else {
			return "user not found";
		}
		change(u,vo.getOldPassword(),vo.getNewPassword());
		return "success";
	}
	
	public void change(User user,String oldPassword,String newPassword) {
		if(encoder.matches(oldPassword,user.getHashedPassword())) {
			user.setHashedPassword(encoder.encode(newPassword));
		}
	}
	
	@GetMapping("/password/{password}")
	public String getEncodedPassword(@PathVariable String password) {
		return encoder.encode(password);
	}
}
