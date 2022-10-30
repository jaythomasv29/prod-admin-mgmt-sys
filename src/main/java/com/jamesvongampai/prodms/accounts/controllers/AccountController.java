package com.jamesvongampai.prodms.accounts.controllers;

import com.jamesvongampai.prodms.accounts.dtos.AccountDto;
import com.jamesvongampai.prodms.accounts.models.Account;
import com.jamesvongampai.prodms.accounts.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/accounts")  //  base path
@AllArgsConstructor
public class AccountController {
  AccountService accountService;


  @PostMapping("/auth/register")
  public ResponseEntity<Account> registerAccount(@RequestBody AccountDto accountDto) {
    return new ResponseEntity<>(accountService.saveAccount(accountDto), HttpStatus.CREATED);
  }


//  @PostMapping("/auth/login")
//  public ResponseEntity<Account> loginAccount(@RequestBody @Valid AccountDto accountDto) {
//    return new ResponseEntity<>(accountService.loginAccount(accountDto), HttpStatus.OK);
//  }

  @GetMapping("/all")
  public ResponseEntity<List<Account>> getAllAccounts(Model model) {
//    model.addAttribute("accounts", accountService.getAccounts());
    return ResponseEntity.ok().body(accountService.getAccounts());
//    return new ResponseEntity<>(accountService.getAccounts(), HttpStatus.OK);
  }



}
