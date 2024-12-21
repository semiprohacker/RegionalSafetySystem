package com.project.regionsafetychecker.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Locations {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long locationId;
	private String locationName;
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "locationmap", joinColumns = @JoinColumn(name = "locationId", referencedColumnName = "locationId"), inverseJoinColumns = @JoinColumn(name = "landmarkId", referencedColumnName = "landmarkId"))
	private List<ModeOfTransport> modesofTransport;

}
