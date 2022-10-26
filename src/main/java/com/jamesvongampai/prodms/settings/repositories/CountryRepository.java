package com.jamesvongampai.prodms.settings.repositories;

import com.jamesvongampai.prodms.settings.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
