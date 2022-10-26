package com.jamesvongampai.prodms.accounts.service;

import com.jamesvongampai.prodms.accounts.dtos.AccountDto;
import com.jamesvongampai.prodms.accounts.models.Account;

import javax.transaction.Transactional;

public interface AccountService {
  @Transactional
  Account saveUser(AccountDto accountDto);
}
