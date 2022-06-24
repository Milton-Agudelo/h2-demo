package com.ada.h2demo.service;

import com.ada.h2demo.entity.Country;
import com.ada.h2demo.repository.CountryRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements ICountryService{

	private final CountryRepository countryRepository;

	@Override
	public List<Country> getCountries() {
		return countryRepository.findAll();
	}

	@Override
	public Optional<Country> getCountry(Long countryId) {
		return countryRepository.findById(countryId);
	}

	@Override
	public boolean isCountryRegistered(Long countryId) {
		return (getCountry(countryId).equals(Optional.empty())) ? false : true;
	}

	@Override
	public Country saveCountry(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public Country updateCountry(Long countryId, Country country) {
		if (isCountryRegistered(countryId)) {
			country.setId(countryId);
			countryRepository.save(country);
		}
		return getCountry(countryId).get();
	}

	@Override
	public boolean deleteCountry(Long countryId) {
		boolean result = false;
		if (isCountryRegistered(countryId)) {
			countryRepository.delete(getCountry(countryId).get());
			result = true;
		}
		return result;
	}
}
