package com.jamesvongampai.prodms.accounts.controllers;

import com.jamesvongampai.prodms.accounts.dtos.AccountDto;
import com.jamesvongampai.prodms.accounts.models.Account;
import com.jamesvongampai.prodms.accounts.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {
  AccountService accountService;
  @PostMapping("/auth/register")
  public ResponseEntity<Account> registerAccount(@RequestBody AccountDto accountDto) {
    return new ResponseEntity<>(accountService.saveUser(accountDto), HttpStatus.OK);
  }


}
