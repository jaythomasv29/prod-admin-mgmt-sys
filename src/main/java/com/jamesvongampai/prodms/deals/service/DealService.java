package com.jamesvongampai.prodms.deals.service;

import com.jamesvongampai.prodms.deals.dtos.DealDto;
import com.jamesvongampai.prodms.deals.models.Deal;

import java.util.List;

public interface DealService {
  List<Deal> getDeals();

  List<Deal> getDealsByAccountId(Long accountId);

  Deal saveDeal(DealDto dealdto, Long accountId, Long businessId);

  Deal updateDeal(DealDto dealDto, Long dealId);

  void deleteDeal(Long dealId);
}
