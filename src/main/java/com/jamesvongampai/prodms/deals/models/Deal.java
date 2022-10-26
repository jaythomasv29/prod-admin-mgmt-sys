package com.jamesvongampai.prodms.deals.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jamesvongampai.prodms.accounts.models.Account;
import com.jamesvongampai.prodms.settings.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deal extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String description;

  private String details;

  private String title;

  @Column(name = "creation_date")
  @CreationTimestamp
  private LocalDateTime creationDate;

  @Column(name = "expiration_date")
  private LocalDateTime expirationDate;

  @Column(name = "image_url")
  private String imageUrl;

  @ManyToOne(optional = false)
  @JsonIgnore
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private Account account;
}
