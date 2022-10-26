package com.jamesvongampai.prodms.accounts.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jamesvongampai.prodms.accounts.dtos.AccountDto;
import com.jamesvongampai.prodms.deals.models.Deal;
import com.jamesvongampai.prodms.settings.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "fullname")
  private String fullname;

  @Column(name = "email", unique = true)
  private String email;
  @Column(name = "password")
  private String password;
  @Column(name = "telephone", unique = true)
  private String telephone;

  private String gender;

//  @Column(name = "creation_date")
//  @CreationTimestamp
//  private LocalDateTime creationDate;

  @JsonIgnore
  @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  private List<Deal> deal;

  public Account(AccountDto accountDto) {
      this.setFullname(accountDto.getFullname());
      this.setEmail(accountDto.getEmail());
      this.setPassword(accountDto.getPassword());
      this.setTelephone(accountDto.getTelephone());
      this.setGender(accountDto.getGender());
      this.setCreatedAt(LocalDateTime.now());
  }
}