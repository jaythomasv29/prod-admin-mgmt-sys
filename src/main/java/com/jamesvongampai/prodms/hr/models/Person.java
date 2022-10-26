package com.jamesvongampai.prodms.hr.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String firstname;
  private String lastname;
  @Formula(value = " concat(firstname, ' ', lastname) ")
  private String fullName;
  private String gender;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date dateOfBirth;
  private String email;
  private String phone;
  private String city;
  private String address;
  private String state;
  private String country;
}
