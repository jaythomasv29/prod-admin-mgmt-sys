package com.jamesvongampai.prodms.settings.controllers;

import com.jamesvongampai.prodms.settings.models.Country;
import com.jamesvongampai.prodms.settings.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/countries")
@Controller

@AllArgsConstructor
public class CountryController {
  private CountryService countryService;

//  @GetMapping()
//    public String getAllCountries(Model model) {
//      model.addAttribute("countries", countryService.getAllCountries());
//    return "countriesTable";
//  }
//  public ResponseEntity<List<Country>> getAllCountries() {
//    return new ResponseEntity<>(countryService.getAllCountries(), HttpStatus.OK);
//  }
//  public String getAllCountries(Model model) {
//      model.addAttribute("countries", countryService.getAllCountries());
//    return "countriesTable";
//  }
}
