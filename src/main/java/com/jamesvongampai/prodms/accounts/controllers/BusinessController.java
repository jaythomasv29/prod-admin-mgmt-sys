package com.jamesvongampai.prodms.accounts.controllers;

import com.jamesvongampai.prodms.accounts.models.Business;
import com.jamesvongampai.prodms.accounts.service.BusinessServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/businesses")
public class BusinessController {
  private BusinessServiceImpl businessService;

  @GetMapping("/all")
    public ResponseEntity<List<Business>> getAllBusinesses() {
      return ResponseEntity.ok().body(businessService.getAllBusinesses());
    }

}
