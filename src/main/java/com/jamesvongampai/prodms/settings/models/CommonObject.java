package com.jamesvongampai.prodms.settings.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass  // parent class to inherit from in order to share similar fields for other tables
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
  property = "id")
@NoArgsConstructor
@AllArgsConstructor
@Data  // toString, Getter, Setter boilerplate
public class CommonObject {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String description;
  private String details;
}
