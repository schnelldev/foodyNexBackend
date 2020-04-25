package com.fm.app.services;

import org.springframework.stereotype.Service;

import com.fm.app.entities.Notification;
import com.fm.app.entities.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseService {
	
    public String saveNotification(Notification notification) {
    	ApiFuture<WriteResult> apiFuture = null;
    	try {
    	Firestore firestore = FirestoreClient.getFirestore();
    	apiFuture = firestore.collection("notification").document("2").set(notification);
    	return apiFuture.get().getUpdateTime().toString();
    	}catch(Exception e){
    		e.printStackTrace();
    		return null;
    	}
    	
    }
    
    public Notification getNotificationById(String documentId) {
    	Notification notification = null;
    	try {
    		Firestore firestore = FirestoreClient.getFirestore();
    		DocumentReference documentReference = firestore.collection("notification").document(documentId);
    		ApiFuture<DocumentSnapshot> future = documentReference.get();
    		DocumentSnapshot documentSnapshot = future.get();
    		if(documentSnapshot!=null) {
    			notification = documentSnapshot.toObject(Notification.class);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return notification;
    }
    
    public String addUserToFirebase(User user,String rawPassword) {
    	String uid = null;
    	try {
    	CreateRequest createRequest = new CreateRequest()
    		    .setEmail(user.getUserName())
    		    .setEmailVerified(false)
    		    .setPassword(rawPassword)
    		    .setPhoneNumber(user.getPhoneNo())
    		    .setDisplayName("John Doe")
    		    .setPhotoUrl("http://www.example.com/12345678/photo.png")
    		    .setDisabled(false);

    		UserRecord userRecord = FirebaseAuth.getInstance().createUser(createRequest);
    		uid =  userRecord.getUid();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return uid;
    }
}
