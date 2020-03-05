package com.gm.base.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Date;
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

import com.gm.base.entities.ClientSeqPrefix;
import com.gm.base.entities.Member;
import com.gm.base.entities.MembershipPackage;
import com.gm.base.entities.Plan;
import com.gm.base.entities.RegimeDay;
import com.gm.base.entities.Trainer;
import com.gm.base.entities.User;
import com.gm.base.enums.UserType;
import com.gm.base.repositories.ClientSeqPrefixRepository;
import com.gm.base.repositories.MemberRepository;
import com.gm.base.repositories.MembershipPackageRepository;
import com.gm.base.repositories.PlanRepository;
import com.gm.base.repositories.TrainerRepository;
import com.gm.base.services.SequenceGeneratorService;

@RestController
@RequestMapping("api/members")
@CrossOrigin
public class MemberController {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	TrainerRepository trainerRepository;

	@Autowired
	PlanRepository planRepository;

	@Autowired
	MembershipPackageRepository membershipPackageRepository;

	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	@Autowired
	BCryptPasswordEncoder encoder;

	@Autowired
	ClientSeqPrefixRepository clientSeqPrefixRepository;

	@Value("${gm.default.password}")
	private String defaultPassword;

	@Value("${gm.images.path}")
	private String imageFolder;

	private final static String MEMBER_FOLDER = "/member/";

	private final static String DEFAULT_FILE_PATH = "/default/default.png";

	private final static String PROFILE_IMAGE = "/profile.png";

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addNewEntity(@RequestBody Member member) {
		Optional<ClientSeqPrefix> optional = clientSeqPrefixRepository.findById(member.getClientId());
		String userId = "";
		if (optional.isPresent()) {
			String prefixStr = optional.get().getPrefixString();
			userId = prefixStr + "M"
					+ sequenceGeneratorService.generateSequence(member.getClientId() + User.MEMBER_SEQUENCE_NAME);
			member.setUserId(userId);
			member.setPhotoUrl(imageFolder + MEMBER_FOLDER + userId + PROFILE_IMAGE);
			member.setHashedPassword(encoder.encode(defaultPassword));
			member.setUserType(UserType.MEMBER);
			member.setMembershipStartDate(LocalDate.now());

			if (member.getMembershipPackage() != null
					&& member.getMembershipPackage().getMembershipPackageId() != null) {
				Optional<MembershipPackage> mpOptional = membershipPackageRepository
						.findById(member.getMembershipPackage().getMembershipPackageId());
				if (mpOptional.isPresent()) {
					MembershipPackage mp = mpOptional.get();
					int noOfDays = mp.getDayCount();
					member.setMembershipEndDate(LocalDate.now().plusDays(noOfDays));
				}
			}
			memberRepository.save(member);
		}
		return userId;
	}

	@GetMapping("/clientId/{clientId}")
	public List<Member> getAll(@PathVariable String clientId) {
		return memberRepository.findByClientId(clientId);
	}

	@GetMapping("/{id}")
	public Member getOne(@PathVariable String id) {
		Optional<Member> optional = memberRepository.findById(id);
		Member member = null;
		if (optional.isPresent()) {
			member = optional.get();
		}
		return member;
	}

	@GetMapping("/clientId/{clientId}/newMembers")
	public List<Member> getAllNewMembers(@PathVariable String clientId) {
		return memberRepository.findByClientIdAndMembershipStartDateGreaterThanEqual(clientId,LocalDate.now().withDayOfMonth(1));
	}
	
	@GetMapping("/clientId/{clientId}/newMembers/count")
	public int getAllNewMembersCount(@PathVariable String clientId) {
		return memberRepository.countByClientIdAndMembershipStartDateGreaterThanEqual(clientId,LocalDate.now().withDayOfMonth(1));
	}

	@PutMapping("/{id}/membershipPackage/add/{packageId}")
	public void updateMembershipPackage(@PathVariable String id, @PathVariable Integer packageId) {
		Optional<Member> optional = memberRepository.findById(id);
		Optional<MembershipPackage> optionalPackage = membershipPackageRepository.findById(packageId);
		if (optionalPackage.isPresent() && optional.isPresent()) {
			Member member = optional.get();
			member.setMembershipPackage(optionalPackage.get());
			memberRepository.save(member);
		}
	}

	@PutMapping("/{id}/plan/add/{planId}")
	public void updatePlan(@PathVariable String id, @PathVariable Integer planId) {
		Optional<Member> optional = memberRepository.findById(id);
		Optional<Plan> optionalPlan = planRepository.findById(planId);
		if (optionalPlan.isPresent() && optional.isPresent()) {
			Member member = optional.get();
			Plan plan = optionalPlan.get();
			plan.setPlanBuyDate(new Date());
			member.getPlan().add(plan);
			memberRepository.save(member);
		}
	}

	@PutMapping("/{id}/regime")
	public void updateRegime(@PathVariable String id, @RequestBody RegimeDay regimeDay) {
		Optional<Member> optional = memberRepository.findById(id);
		if (optional.isPresent()) {
			Member member = optional.get();

			boolean isPresent = false;
			for (RegimeDay x : member.getRegimeDays()) {
				if (x.getDayOfWeek() == regimeDay.getDayOfWeek()) {
					isPresent = true;
					x.setRegimeText(regimeDay.getRegimeText());
				}
			}
			if (!isPresent) {
				member.getRegimeDays().add(regimeDay);
			}
			memberRepository.save(member);
		}
	}

	@PutMapping("/{id}/trainer/{trainerId}")
	public void updateTrainer(@PathVariable String id, @PathVariable String trainerId) {
		Optional<Member> optional = memberRepository.findById(id);
		if (optional.isPresent()) {
			Member member = optional.get();
			Trainer trainer = null;
			if (trainerRepository.findById(trainerId).isPresent()) {
				trainer = trainerRepository.findById(trainerId).get();
			}
			member.setTrainer(trainer);
			memberRepository.save(member);
		}
	}

	@PutMapping("/{id}/biometricId/{biometricId}")
	public void updateBiometricId(@PathVariable String id, @PathVariable String biometricId) {
		Optional<Member> optional = memberRepository.findById(id);
		if (optional.isPresent()) {
			Member member = optional.get();
			member.setBiometricId(biometricId);
		}
	}

	@PostMapping("/{id}/photo")
	public String singleFileUpload(@PathVariable String id, @RequestParam("photo") MultipartFile photo)
			throws IOException {
		String destination = imageFolder + MEMBER_FOLDER + id;
		File file = new File(destination);
		if (!file.exists()) {
			file.mkdirs();
		}
		String memberPhoto = imageFolder + MEMBER_FOLDER + id + PROFILE_IMAGE;
		File memberPhotoFile = new File(memberPhoto);
		if (photo.getOriginalFilename().endsWith("png")) {
			photo.transferTo(memberPhotoFile);
		}

		return photo.getName();
	}

	@GetMapping(value = "/{id}/profilePhoto", produces = MediaType.IMAGE_PNG_VALUE)
	public void getImage(@PathVariable String id, HttpServletResponse response) throws IOException {

		File imgFile = new File(imageFolder + MEMBER_FOLDER + id + PROFILE_IMAGE);
		File defaultImageFile = new File(imageFolder + DEFAULT_FILE_PATH);
		try (InputStream is = new FileInputStream(imgFile)) {
			response.setContentType(MediaType.IMAGE_PNG_VALUE);
			StreamUtils.copy(is, response.getOutputStream());
		} catch (FileNotFoundException fileNotFoundException) {
			try (InputStream is = new FileInputStream(defaultImageFile)) {
				response.setContentType(MediaType.IMAGE_PNG_VALUE);
				StreamUtils.copy(is, response.getOutputStream());
			}
		}
	}
}