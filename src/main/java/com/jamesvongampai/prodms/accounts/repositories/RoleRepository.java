package com.jamesvongampai.prodms.accounts.repositories;

import com.jamesvongampai.prodms.accounts.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Role findByName(String name);
}
