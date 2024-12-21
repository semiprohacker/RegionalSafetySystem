package com.project.regionsafetychecker.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "transport")
public class ModeOfTransport {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long landmarkId;
	private String placeName;
	private String description;
	@ManyToMany(mappedBy = "modesofTransport")
	private List<Locations> location;

}
