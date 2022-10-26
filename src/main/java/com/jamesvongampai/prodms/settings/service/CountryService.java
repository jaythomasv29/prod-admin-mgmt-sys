package com.jamesvongampai.prodms.settings.service;

import com.jamesvongampai.prodms.settings.models.Country;
import com.jamesvongampai.prodms.settings.repositories.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CountryService {
  private CountryRepository countryRepository;


  public List<Country> getAllCountries() {
    List<Country> countries = countryRepository.findAll();
      return countries;

  }
}
