package com.jamesvongampai.prodms.deals.controllers;

import com.jamesvongampai.prodms.deals.dtos.DealDto;
import com.jamesvongampai.prodms.deals.models.Deal;
import com.jamesvongampai.prodms.deals.service.DealServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/deals")
@AllArgsConstructor
public class DealsController {
  DealServiceImpl dealService;

  @GetMapping("/all")
  public ResponseEntity<List<Deal>> getAllDeals() {
    return new ResponseEntity<>(dealService.getDeals(), HttpStatus.OK);
  }

  @GetMapping("all/{accountId}")
  public ResponseEntity<List<Deal>> getDealsByAccountId(@PathVariable Long accountId) {
    return new ResponseEntity<>(dealService.getDealsByAccountId(accountId), HttpStatus.OK);
  }

  @PostMapping("/add/{accountId}/{businessId}")
  public ResponseEntity<Deal> addDeal(@RequestBody DealDto dealDto, @PathVariable Long accountId, @PathVariable Long businessId) {
    return new ResponseEntity<>(dealService.saveDeal(dealDto, accountId, businessId), HttpStatus.CREATED);
  }

  @PutMapping("/edit/{dealId}")
  public ResponseEntity<Deal> editDealByAccountId(@RequestBody DealDto dealDto, @PathVariable Long dealId) {
    return new ResponseEntity<>(dealService.updateDeal(dealDto, dealId), HttpStatus.OK);
  }

  @DeleteMapping("/delete/{dealId}")
  public ResponseEntity<Object> deleteDealById(@PathVariable Long dealId) {
    dealService.deleteDeal(dealId);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }


}
