package com.jamesvongampai.prodms.accounts.service;

import com.jamesvongampai.prodms.accounts.dtos.AccountDto;
import com.jamesvongampai.prodms.accounts.dtos.RoleDto;
import com.jamesvongampai.prodms.accounts.models.Account;
import com.jamesvongampai.prodms.accounts.models.Role;

import javax.transaction.Transactional;
import java.util.List;

public interface AccountService {
  @Transactional
  Account saveAccount(AccountDto accountDto);

  Role saveRole(RoleDto roleDto);

  void addRoleToAccount(String email, String roleName);

  Account getAccount(String email);

  @Transactional
  Account loginAccount(AccountDto accountDto);

  List<Account> getAccounts();
}


