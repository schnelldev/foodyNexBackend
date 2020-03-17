package com.gm.base.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gm.base.entities.PostOffice;
import com.gm.base.repositories.PostOfficeRepository;
import com.gm.base.services.SequenceGeneratorService;

@RestController
@RequestMapping("api/pos")
@CrossOrigin
public class PostOfficeController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	PostOfficeRepository postOfficeRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	@GetMapping
	public void getAll() {
		postOfficeRepository.deleteAll();

		Runnable task1=()-> {
			System.out.println("Task 1 ");
			process(100000,149999);
		};
		
		Runnable task2=()-> {
			System.out.println("Task 2 ");
			process(150000,199999);
		};
		
		Runnable task3=()-> {
			System.out.println("Task 3 ");
			process(200000,249999);
		};
		
		Runnable task4=()-> {
			System.out.println("Task 4 ");
			process(250000,299999);
		};
		
		Runnable task5=()-> {
			System.out.println("Task 5 ");
			process(300000,349999);
		};
		
		Runnable task6=()-> {
			System.out.println("Task 6 ");
			process(350000,399999);
		};
		
		Runnable task7=()-> {
			System.out.println("Task 7 ");
			process(400000,449999);
		};
		
		Runnable task8=()-> {
			System.out.println("Task 8 ");
			process(450000,499999);
		};
		Runnable task9=()-> {
			System.out.println("Task 9 ");
			process(500000,549999);
		};
		
		Runnable task10=()-> {
			System.out.println("Task 10 ");
			process(550000,599999);
		};
		
		Runnable task11=()-> {
			System.out.println("Task 11 ");
			process(600000,649999);
		};
		
		Runnable task12=()-> {
			System.out.println("Task 12 ");
			process(650000,699999);
		};
		
		Runnable task13=()-> {
			System.out.println("Task 13 ");
			process(700000,749999);
		};
		
		Runnable task14=()-> {
			System.out.println("Task 14 ");
			process(750000,799999);
		};
		
		Runnable task15=()-> {
			System.out.println("Task 15 ");
			process(800000,849999);
		};
		
		Runnable task16=()-> {
			System.out.println("Task 16 ");
			process(850000,899999);
		};
		
		Runnable task17=()-> {
			System.out.println("Task 17 ");
			process(900000,949999);
		};
		
		Runnable task18=()-> {
			System.out.println("Task 18 ");
			process(950000,999999);
		};
		
		
		new Thread(task1).start();
		new Thread(task2).start();
		new Thread(task3).start();
		new Thread(task4).start();
		new Thread(task5).start();
		new Thread(task6).start();
		new Thread(task7).start();
		new Thread(task8).start();
		new Thread(task9).start();
		new Thread(task10).start();
		new Thread(task11).start();
		new Thread(task12).start();
		new Thread(task13).start();
		new Thread(task14).start();
		new Thread(task15).start();
		new Thread(task16).start();
		new Thread(task17).start();
		new Thread(task18).start();
	}
	
	
	private void process (int startIndex , int endIndex) {
		for(int pincode= startIndex; pincode<endIndex;pincode++) {
			System.out.println(pincode);
			List<LinkedHashMap<String, Object>> response = restTemplate.getForObject(
				  "https://api.postalpincode.in/pincode/" + pincode,List.class);
				if(response.size()>0) {
					//System.out.println(response.get(0).get("Message"));
					//System.out.println(response.get(0).get("Status"));
					
					if(response.get(0).get("Status").equals("Success")?true :false) {
						for(Object o :(List)response.get(0).get("PostOffice")) {
							Map<String, Object> map = (Map)o;
							System.out.println(map.get("Name"));
							System.out.println(map.get("Circle"));
							System.out.println(map.get("District"));
							System.out.println(map.get("Pincode"));
							System.out.println(map.get("Name"));
							PostOffice postOffice = new PostOffice();
							
							postOffice.setPostOfficeId(sequenceGeneratorService.generateSequence(PostOffice.SEQUENCE_NAME));
							postOffice.setName((String)map.get("Name"));
							postOffice.setDistrict((String)map.get("District"));
							postOffice.setCircle((String)map.get("Circle"));
							postOffice.setState((String)map.get("State"));
							postOffice.setPincode((String)map.get("Pincode"));
							
							postOfficeRepository.save(postOffice);
						}
					}
				}
		}
	}
}
