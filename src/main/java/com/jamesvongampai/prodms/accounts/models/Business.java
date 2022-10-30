package com.jamesvongampai.prodms.accounts.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jamesvongampai.prodms.deals.models.Deal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data @Entity @NoArgsConstructor @AllArgsConstructor
public class Business {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String address;
  private String telephone;
  private String email;

  @JsonIgnore
  @OneToMany(mappedBy = "business", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  private List<Deal> deal;
}
