package com.majian.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnumTypeHandlerApplication implements CommandLineRunner{

	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(EnumTypeHandlerApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		personService.save();
		personService.getAll();

	}
}
