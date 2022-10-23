package com.jamesvongampai.prodms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
  @GetMapping("/")
  public String getIndex() {
    return "pages-register";
  }

  @GetMapping("/register")
  public String getRegister() { return "pages-register"; };

}


