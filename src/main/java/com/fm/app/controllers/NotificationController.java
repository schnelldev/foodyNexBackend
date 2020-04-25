package com.fm.app.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fm.app.entities.Notification;
import com.fm.app.services.FirebaseService;

@RestController
@RequestMapping("api/notifications")
public class NotificationController {

	@Autowired
	FirebaseService firebaseService;
	
	@GetMapping
	public String addNotification() {
		Notification notification = new Notification();
		notification.setNotificationTitle("Firebase Basics");
		notification.setNotificationText("Hello World 2");
		notification.setCreatedDate(new Date());
		firebaseService.saveNotification(notification);
		return "success";
	}
	
	@GetMapping("/{id}")
	public Notification getNotificationById(@PathVariable String id) {
		return firebaseService.getNotificationById(id);
	}
}
