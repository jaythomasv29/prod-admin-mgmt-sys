package com.jamesvongampai.prodms.accounts.service;

import com.jamesvongampai.prodms.accounts.dtos.BusinessDto;
import com.jamesvongampai.prodms.accounts.models.Business;

public interface BusinessService {
  Business saveBusiness(BusinessDto businessDto);
}
