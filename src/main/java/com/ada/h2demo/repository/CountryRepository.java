package com.ada.h2demo.repository;

import com.ada.h2demo.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
