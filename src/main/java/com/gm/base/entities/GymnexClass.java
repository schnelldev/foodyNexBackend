package com.gm.base.entities;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gm.base.enums.ClassTime;

@Document
public class GymnexClass {
	

		@Transient
		public static final String SEQUENCE_NAME = "gymnex_class_sequence";
		
		@Id
		int gymnexClassId;
		String className;
		String description;
		List<ClassTime> classTimes; 
		boolean scheduleTwice;
		LocalTime morningStartTime;
		LocalTime morningEndTime;
		LocalTime eveningStartTime;
		LocalTime eveningEndTime;
		
		
		public int getGymnexClassId() {
			return gymnexClassId;
		}
		public void setGymnexClassId(int gymnexClassId) {
			this.gymnexClassId = gymnexClassId;
		}
		public String getClassName() {
			return className;
		}
		public void setClassName(String className) {
			this.className = className;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public List<ClassTime> getClassTimes() {
			return classTimes;
		}
		public void setClassTimes(List<ClassTime> classTimes) {
			this.classTimes = classTimes;
		}
		public boolean isScheduleTwice() {
			return scheduleTwice;
		}
		public void setScheduleTwice(boolean scheduleTwice) {
			this.scheduleTwice = scheduleTwice;
		}
		public LocalTime getMorningStartTime() {
			return morningStartTime;
		}
		public void setMorningStartTime(LocalTime morningStartTime) {
			this.morningStartTime = morningStartTime;
		}
		public LocalTime getMorningEndTime() {
			return morningEndTime;
		}
		public void setMorningEndTime(LocalTime morningEndTime) {
			this.morningEndTime = morningEndTime;
		}
		public LocalTime getEveningStartTime() {
			return eveningStartTime;
		}
		public void setEveningStartTime(LocalTime eveningStartTime) {
			this.eveningStartTime = eveningStartTime;
		}
		public LocalTime getEveningEndTime() {
			return eveningEndTime;
		}
		public void setEveningEndTime(LocalTime eveningEndTime) {
			this.eveningEndTime = eveningEndTime;
		}
		
}
