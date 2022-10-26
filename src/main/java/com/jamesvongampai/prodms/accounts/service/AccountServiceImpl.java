package com.jamesvongampai.prodms.accounts.service;

import com.jamesvongampai.prodms.accounts.dtos.AccountDto;
import com.jamesvongampai.prodms.accounts.models.Account;
import com.jamesvongampai.prodms.accounts.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
  private AccountRepository accountRepository;
  private BCryptPasswordEncoder passwordEncoder;

  @Override
  @Transactional
  public Account saveUser(AccountDto accountDto) {
    Account account = new Account(accountDto);
    account.setPassword(passwordEncoder.encode(accountDto.getPassword()));  // hash password before saving to db
    return accountRepository.saveAndFlush(account);
  }

  public static Account unwrapAccount(Optional<Account> wrappedAccount) {
    if(wrappedAccount.isPresent()){
      return wrappedAccount.get();
    }
    throw new RuntimeException();
  }
}
