package com.jamesvongampai.prodms.accounts.dtos;

import com.jamesvongampai.prodms.deals.models.Deal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessDto {
  private Long id;
  private String name;
  private String address;
  private String telephone;
  private String email;
  private List<Deal> deals;
}
