package com.jamesvongampai.prodms.accounts.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jamesvongampai.prodms.accounts.models.Role;
import com.jamesvongampai.prodms.deals.models.Deal;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class AccountDto implements Serializable {
  private Long id;
  private String fullname;
  private String email;
  private String password;
  private String telephone;
  private String gender;
  private LocalDateTime creationDate;
  private List<Role> roles = new ArrayList<>();
  private List<Deal> deals = new ArrayList<>();

  public AccountDto(String fullname, String email, String password, String telephone, String gender) {
    this.fullname = fullname;
    this.email = email;
    this.password = password;
    this.telephone = telephone;
    this.gender = gender;
  }
}
