package com.jamesvongampai.prodms.accounts.controllers;

import com.jamesvongampai.prodms.accounts.dtos.RoleDto;
import com.jamesvongampai.prodms.accounts.models.Role;
import com.jamesvongampai.prodms.accounts.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @AllArgsConstructor
@RequestMapping("/role")
public class RoleController {
  private AccountService accountService;

  @PostMapping("/save")
  public ResponseEntity<Role> saveRole(@RequestBody RoleDto roleDto) {
    return new ResponseEntity<>(accountService.saveRole(roleDto), HttpStatus.CREATED);
  }

  @PostMapping("/add")
  public ResponseEntity<Object> addRoleToUser(@RequestBody RoleToUserForm form) {
    accountService.addRoleToAccount(form.getEmail(), form.getRoleName());
    return new ResponseEntity<>(HttpStatus.OK);
  }
}

@Data
class RoleToUserForm {
  private String email;
  private String roleName;
}
