package com.jamesvongampai.prodms.deals.repositories;

import com.jamesvongampai.prodms.deals.models.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {
  List<Deal> findAllByAccountId(Long accountId);
}
