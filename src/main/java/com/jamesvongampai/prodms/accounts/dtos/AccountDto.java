package com.jamesvongampai.prodms.accounts.dtos;

import com.jamesvongampai.prodms.deals.models.Deal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto implements Serializable {

  private Long id;
  private String fullname;
  private String email;
  private String password;
  private String telephone;
  private String gender;
  private LocalDateTime creationDate;
  private List<Deal> deals = new ArrayList<>();

}
