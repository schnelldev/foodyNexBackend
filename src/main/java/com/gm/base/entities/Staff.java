package com.gm.base.entities;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Staff extends User{
	
	String designation;
	String staffWork;
	int salaryMonthly;
	Date doj;
}
