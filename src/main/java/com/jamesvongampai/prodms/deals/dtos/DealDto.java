package com.jamesvongampai.prodms.deals.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jamesvongampai.prodms.accounts.models.Account;
import com.jamesvongampai.prodms.accounts.models.Business;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DealDto implements Serializable {
  private Long id;
  private String category;
  private String title;
  private String description;
  private LocalDateTime expirationDate;
  private String imageUrl;
  private Long businessId;
  private Account account;
  private Business business;

}
