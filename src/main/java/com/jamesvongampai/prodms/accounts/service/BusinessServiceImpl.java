package com.jamesvongampai.prodms.accounts.service;

import com.jamesvongampai.prodms.accounts.dtos.BusinessDto;
import com.jamesvongampai.prodms.accounts.models.Business;
import com.jamesvongampai.prodms.accounts.repositories.BusinessRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class BusinessServiceImpl implements BusinessService {
  private BusinessRepository businessRepository;

  @Override
  public Business saveBusiness(BusinessDto businessDto) {
    Business business = new Business(businessDto);
    return businessRepository.saveAndFlush(business);
  }

  public List<Business> getAllBusinesses() {
    return businessRepository.findAll();
  }
}
