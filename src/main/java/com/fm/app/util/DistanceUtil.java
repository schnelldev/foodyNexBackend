package com.fm.app.util;

import com.fm.app.entities.Client;

public class DistanceUtil {

	public static double getDistance(Client client,double latitude,double longitude) {
		return  6371 * Math.acos(
		        Math.sin(inRadian(client.getLatitude())) * Math.sin(inRadian(latitude))
		        + Math.cos(inRadian(client.getLatitude())) * Math.cos(inRadian(latitude)) * Math.cos(inRadian(longitude) - inRadian(client.getLongitude())));
	}
	
	public static double inRadian(double degrees) {
		 return (Math.PI * degrees) / 180;
	}
}
