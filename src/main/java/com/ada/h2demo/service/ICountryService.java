package com.ada.h2demo.service;

import com.ada.h2demo.entity.Country;
import java.util.List;
import java.util.Optional;

public interface ICountryService {
	List<Country> getCountries();

	boolean isCountryRegistered(Long countryId);

	Country saveCountry(Country country);

	Optional<Country> getCountry(Long countryId);

	Country updateCountry(Long countryId, Country country);

	boolean deleteCountry(Long countryId);

}
