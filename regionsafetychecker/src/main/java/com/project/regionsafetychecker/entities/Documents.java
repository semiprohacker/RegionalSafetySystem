package com.project.regionsafetychecker.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Documents {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long docId;
	private String type;
	@Embedded
	private DocNumber docNumber;
	@OneToOne(mappedBy = "document")
	private User user;
}

