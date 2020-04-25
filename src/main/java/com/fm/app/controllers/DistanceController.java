package com.fm.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fm.app.entities.Client;
import com.fm.app.util.DistanceUtil;

@RestController
@RequestMapping("/api/distance")
public class DistanceController {
	
	
	@GetMapping
	public double distance(@RequestParam double latitude,@RequestParam double longitude) {
		Client c = new Client();
		c.setLatitude(19.288108);
		c.setLongitude(73.0516984);
		return DistanceUtil.getDistance(c, latitude, longitude);
	}
}
