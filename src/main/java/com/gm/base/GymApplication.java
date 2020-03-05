package com.gm.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import com.gm.base.services.ClientSeqPrefixService;

@SpringBootApplication
public class GymApplication {

	@Value("${spring.data.mongodb.database}")
	private String database;

	@Value("${spring.data.mongodb.host}")
	private String databaseHost;

	@Value("${spring.data.mongodb.port}")
	private Integer databasePort;
	
	@Autowired
	ClientSeqPrefixService clientSeqPrefixService;

	public static void main(String[] args) {
		SpringApplication.run(GymApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public void loadAllClients() {
		clientSeqPrefixService.loadAllClients();
	}
}
