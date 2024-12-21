package com.project.regionsafetychecker.entities;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class DocNumber {
	private String number;
	@Temporal(TemporalType.DATE)
	private LocalDate start;
	@Temporal(TemporalType.DATE)
	private LocalDate end;
}
 	