package com.jamesvongampai.prodms;

import com.jamesvongampai.prodms.settings.models.Country;
import com.jamesvongampai.prodms.settings.models.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProdMsApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(ProdMsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
