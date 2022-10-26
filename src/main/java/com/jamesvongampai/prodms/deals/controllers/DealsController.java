package com.jamesvongampai.prodms.deals.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deals")
public class DealsController {

  @GetMapping("/all")
  public String getAllDeals() {
    return "deals/dealsTable";
  }
}
