package com.project.regionsafetychecker.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

	private String line1;
	private String line2;
	private String zipCode;
	private String contactDetails;
	
}
