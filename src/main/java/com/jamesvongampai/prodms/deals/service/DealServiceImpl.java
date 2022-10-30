package com.jamesvongampai.prodms.deals.service;

import com.jamesvongampai.prodms.accounts.models.Account;
import com.jamesvongampai.prodms.accounts.models.Business;
import com.jamesvongampai.prodms.accounts.repositories.AccountRepository;
import com.jamesvongampai.prodms.accounts.repositories.BusinessRepository;
import com.jamesvongampai.prodms.deals.dtos.DealDto;
import com.jamesvongampai.prodms.deals.models.Deal;
import com.jamesvongampai.prodms.deals.repositories.DealRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DealServiceImpl implements DealService {
  DealRepository dealRepository;
  AccountRepository accountRepository;
  BusinessRepository businessRepository;


  @Override
  public List<Deal> getDeals() {
    return dealRepository.findAll();
  }

  @Override
  public List<Deal> getDealsByAccountId(Long accountId) {
    return dealRepository.findAllByAccountId(accountId);
  }

  @Override
  public Deal saveDeal(DealDto dealDto, Long accountId, Long businessId) {
    Account foundAccount = unwrapAccount(accountRepository.findById(accountId));
    Business foundBusiness = unwrapBusiness(businessRepository.findById(businessId));
    Deal deal = new Deal(dealDto);
    deal.setAccount(foundAccount);
    deal.setBusiness(foundBusiness);
    return dealRepository.saveAndFlush(deal);
  }

  @Override
  public Deal updateDeal(DealDto dealDto, Long dealId) {
    Optional<Deal> foundDeal = dealRepository.findById(dealId);

    Deal deal = unwrapDeal(foundDeal, null, dealId);
    deal.setCategory(dealDto.getCategory());
    deal.setTitle(dealDto.getTitle());
    deal.setDescription(dealDto.getDescription());
    deal.setImageUrl(deal.getImageUrl());
    return dealRepository.saveAndFlush(deal);
  }

  @Override
  public void deleteDeal(Long dealId) {
    dealRepository.deleteById(dealId);
  }

  public Deal unwrapDeal(Optional<Deal> entity, Long accountId, Long dealId) {
    if(entity.isPresent()) return entity.get();
    else throw new RuntimeException("Deal with accountId not found");
  }

  public Business unwrapBusiness(Optional<Business> entity) {
    if(entity.isPresent()) return entity.get();
    else throw new RuntimeException("Business with businessId not found");
  }

  public Account unwrapAccount(Optional<Account> entity) {
    if(entity.isPresent()) return entity.get();
    else throw new RuntimeException("Account with accountId not found");
  }

}
