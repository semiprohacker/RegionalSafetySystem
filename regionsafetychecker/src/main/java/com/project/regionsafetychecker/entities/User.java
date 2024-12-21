package com.project.regionsafetychecker.entities;

import java.util.LinkedList;
import java.util.List;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Reviwer")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	
	private String userName;
	@NonNull
	@NotEmpty
	@Column(name = "firstName")
	private String fName;
	@NotNull
	@NotEmpty
	private String surName;
	@Embedded
	private Address address;
	@Email
	private String email;
	@Pattern(regexp = "^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$\r\n")
	private String number;
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Reviews> reviewList;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "docID")
	private Documents document;
	
	
	
   public void addNewReviews(Reviews review) {
	   if(review!=null) {
		   if(reviewList==null) {
			   reviewList = new LinkedList<Reviews>();
		   }
		   reviewList.add(review);
		   review.setUser(this);
	   }
   }
}
