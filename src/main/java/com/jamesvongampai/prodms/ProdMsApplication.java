package com.jamesvongampai.prodms;

import com.jamesvongampai.prodms.accounts.dtos.AccountDto;
import com.jamesvongampai.prodms.accounts.dtos.RoleDto;
import com.jamesvongampai.prodms.accounts.service.AccountService;
import com.jamesvongampai.prodms.settings.models.Country;
import com.jamesvongampai.prodms.settings.models.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class ProdMsApplication implements CommandLineRunner {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}



	public static void main(String[] args) {
		SpringApplication.run(ProdMsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
	@Bean
	CommandLineRunner run (AccountService accountService) {
		return args -> {
			accountService.saveRole(new RoleDto(null, "ROLE_USER"));
			accountService.saveRole(new RoleDto(null, "ROLE_MANAGER"));
			accountService.saveRole(new RoleDto(null, "ROLE_ADMIN"));
			accountService.saveRole(new RoleDto(null, "ROLE_SUPER_ADMIN"));
			accountService.saveAccount(new AccountDto("james", "james@email.com", "pass123", "4087477721", "male"));
			accountService.saveAccount(new AccountDto("jantira", "jantira@email.com", "pass123", "4087477722", "male"));
			accountService.saveAccount(new AccountDto("jimmy", "jimmy@email.com", "pass123", "4087477723", "male"));
//
			accountService.addRoleToAccount("james@email.com", "ROLE_SUPER_ADMIN");
			accountService.addRoleToAccount("james@email.com", "ROLE_MANAGER");

			accountService.addRoleToAccount("jantira@email.com", "ROLE_ADMIN");
		};
	}

}
