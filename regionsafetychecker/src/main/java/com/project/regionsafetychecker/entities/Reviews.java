package com.project.regionsafetychecker.entities;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reviews {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long reviewid;
	private String title;
	private String review;
	
	@ManyToOne
	@JoinColumn(name = "id")
private User user;

}
