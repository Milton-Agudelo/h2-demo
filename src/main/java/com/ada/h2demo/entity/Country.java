package com.ada.h2demo.entity;

import static javax.persistence.GenerationType.IDENTITY;

import com.ada.h2demo.controller.dto.CountryDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	public Country(CountryDto countryDto) {
		this(countryDto.getId(), countryDto.getName());
	}
}
