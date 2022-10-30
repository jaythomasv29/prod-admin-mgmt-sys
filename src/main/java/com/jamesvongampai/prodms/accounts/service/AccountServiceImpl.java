package com.jamesvongampai.prodms.accounts.service;

import com.jamesvongampai.prodms.accounts.dtos.AccountDto;
import com.jamesvongampai.prodms.accounts.dtos.RoleDto;
import com.jamesvongampai.prodms.accounts.models.Account;
import com.jamesvongampai.prodms.accounts.models.Role;
import com.jamesvongampai.prodms.accounts.repositories.AccountRepository;
import com.jamesvongampai.prodms.accounts.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService, UserDetailsService {
  private AccountRepository accountRepository;
  private RoleRepository roleRepository;
//  @Autowired
  private PasswordEncoder crypt;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Account account = accountRepository.findByEmail(email).get();
    if(account == null) {
      throw new UsernameNotFoundException("email does not match as the username");
    }
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    account.getRoles().forEach(role -> {
      authorities.add(new SimpleGrantedAuthority(role.getName()));
    });
    return new org.springframework.security.core.userdetails.User(account.getEmail(), account.getPassword(), authorities);
  }

  @Override
  public Account saveAccount(AccountDto accountDto) {
    Account account = new Account(accountDto);
    Role role = roleRepository.findByName("ROLE_USER");
    account.getRoles().add(role);
    account.setPassword(crypt.encode(accountDto.getPassword()));  // hash password before saving to db
    return accountRepository.saveAndFlush(account);
  }

  @Override
  public Role saveRole(RoleDto roleDto) {
    return roleRepository.save(new Role(roleDto));
  }

  @Override
  public void addRoleToAccount(String email, String roleName) {
    Account account = accountRepository.findByEmail(email).get();
    Role role = roleRepository.findByName(roleName);
    account.getRoles().add(role);
  }

  @Override
  public Account getAccount(String email) {
    return accountRepository.findByEmail(email).get();
  }

  @Override
  public Account loginAccount(AccountDto accountDto) {
    Optional<Account> wrappedAccount = accountRepository.findByEmail(accountDto.getEmail());
    Account unwrappedAccount = unwrapAccount(wrappedAccount);
    if(crypt.matches(accountDto.getPassword(), unwrappedAccount.getPassword())) {
      return unwrappedAccount;
    }
    throw new RuntimeException("Authentication Failed");
  }

  @Override
  public List<Account> getAccounts() {
    return accountRepository.findAll();
  }

  public static Account unwrapAccount(Optional<Account> wrappedAccount) {
    if(wrappedAccount.isPresent()){
      return wrappedAccount.get();
    }
    throw new RuntimeException("User does not exist");
  }
}
