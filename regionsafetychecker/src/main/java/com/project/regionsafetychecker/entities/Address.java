package com.project.regionsafetychecker.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Address {

	private String line1;
	private String line2;
	private String zipCode;
	private String contactDetails;
	
}
