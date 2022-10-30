package com.jamesvongampai.prodms.accounts.models;

import com.jamesvongampai.prodms.accounts.dtos.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data @Entity @NoArgsConstructor @AllArgsConstructor
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  public Role(RoleDto roleDto) {
    this.setName(roleDto.getName());
  }

}
