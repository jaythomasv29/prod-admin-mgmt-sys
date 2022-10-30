package com.jamesvongampai.prodms.accounts.repositories;
import com.jamesvongampai.prodms.accounts.models.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
}
