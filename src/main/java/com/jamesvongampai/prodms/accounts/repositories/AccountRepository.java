package com.jamesvongampai.prodms.accounts.repositories;

import com.jamesvongampai.prodms.accounts.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
