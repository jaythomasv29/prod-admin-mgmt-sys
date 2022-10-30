package com.jamesvongampai.prodms.deals.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jamesvongampai.prodms.accounts.models.Account;
import com.jamesvongampai.prodms.accounts.models.Business;
import com.jamesvongampai.prodms.deals.dtos.DealDto;

import com.jamesvongampai.prodms.settings.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deal extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String category;
  private String title;
  private String description;

  @ManyToOne(optional = false)
  @JoinColumn(name = "business_id", referencedColumnName = "id")
  private Business business;

  private int likes;

  @Column(name = "creation_date")
  @CreationTimestamp
  private LocalDateTime creationDate;

  @Column(name = "expiration_date")
  private LocalDateTime expirationDate;

  @Column(name = "image_url")
  private String imageUrl;

  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private Account account;

  public Deal(DealDto dealDto) {
    this.description = dealDto.getDescription();
    this.category = dealDto.getCategory();
    this.title = dealDto.getTitle();
    this.creationDate = LocalDateTime.now();
    this.expirationDate = dealDto.getExpirationDate();
    this.imageUrl = dealDto.getImageUrl();
    this.business = dealDto.getBusiness();
    this.setLikes(0);

  }
}
