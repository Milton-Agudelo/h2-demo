package com.ada.h2demo.controller;

import com.ada.h2demo.controller.dto.CountryDto;
import com.ada.h2demo.entity.Country;
import com.ada.h2demo.service.ICountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/country/")
public class CountryController {

	private final ICountryService iCountryService;

	private ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Country with specified id, can not be found!");

	public CountryController(ICountryService iCountryService) {
		this.iCountryService = iCountryService;
	}

	@GetMapping("/list")
	public ResponseEntity<Iterable<Country>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(iCountryService.getCountries());
	}

	@PostMapping("/")
	private ResponseEntity<Country> save(@RequestBody CountryDto countryDto) {
		return ResponseEntity.status(HttpStatus.OK).body(iCountryService.saveCountry(new Country(countryDto)));
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Country> findById(@PathVariable Long id) {
		ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Fireman  with id: '" + id + "' can not be found!");
		try {
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(iCountryService.getCountry(id));
   /*   } catch (Exception e) {
            throw new Exception(e.getMessage()); // */
		}  finally {
			return responseEntity;
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Country> update(@PathVariable Long id, @RequestBody CountryDto countryDto) {
		try {
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(iCountryService.updateCountry(id, new Country(countryDto)));
	/*   } catch (Exception e) {
            throw new Exception(e.getMessage()); // */
		} finally {
			return responseEntity;
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if (iCountryService.deleteCountry(id)) {
			responseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return responseEntity;
	}
}
