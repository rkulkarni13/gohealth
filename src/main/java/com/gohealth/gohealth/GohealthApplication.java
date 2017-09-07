package com.gohealth.gohealth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class)
public class GohealthApplication {

	public static void main(String[] args) {
		SpringApplication.run(GohealthApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(RegistrationRepository rr)
	{
		return args -> {
			getRegistrationList().forEach(n -> rr.save(n));

			rr.findAll().forEach(System.out::println);
		};
	}

	private ArrayList<Registration> getRegistrationList()
	{
		ArrayList<Registration> registrationList = new ArrayList<Registration>();
		Registration reg1 = new Registration("Kulkarni","Ramesh","C","1980-01-01","Y",
				"1234567","UHG");
		registrationList.add(reg1);

		return registrationList;
	}

}
