package com.jamesvongampai.prodms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
  @GetMapping("/")
  public String getIndex() {
    return "index";
  }

  @GetMapping("/register")
  public String getRegister() { return "pages-register"; }

  @GetMapping("/hr")
  public String getHumanResourceIndex() { return "/hr/index"; }


  @GetMapping("/accounts")
  public String getAccountsIndex() { return "/accounts/index"; }



  @GetMapping("/products")
  public String getProductsIndex() { return "/products/index"; }

  @GetMapping("/employees")
  public String getPayrollIndex() { return "/employees/index"; }

}



