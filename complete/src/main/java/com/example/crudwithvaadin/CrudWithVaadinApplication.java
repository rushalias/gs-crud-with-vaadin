package com.example.crudwithvaadin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudWithVaadinApplication {

	private static final Logger log = LoggerFactory.getLogger(CrudWithVaadinApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CrudWithVaadinApplication.class);
	}

	@Bean
	public CommandLineRunner loadData(CustomerRepository repository) {
		return (args) -> {
			// save a couple of customers
			Customer jack = new Customer("Jack", "Bauer");
			jack.setCity("Los Angeles");
			jack.setState("California");
			jack.setCountry("USA");
			repository.save(jack);

			Customer chloe = new Customer("Chloe", "O'Brian");
			chloe.setCity("Washington");
			chloe.setState("D.C.");
			chloe.setCountry("USA");
			repository.save(chloe);

			Customer kim = new Customer("Kim", "Bauer");
			kim.setCity("Los Angeles");
			kim.setState("California");
			kim.setCountry("USA");
			repository.save(kim);

			Customer david = new Customer("David", "Palmer");
			david.setCity("Washington");
			david.setState("D.C.");
			david.setCountry("USA");
			repository.save(david);

			Customer michelle = new Customer("Michelle", "Dessler");
			michelle.setCity("Los Angeles");
			michelle.setState("California");
			michelle.setCountry("USA");
			repository.save(michelle);

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L).get();
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastNameStartsWithIgnoreCase('Bauer'):");
			log.info("--------------------------------------------");
			for (Customer bauer : repository
					.findByLastNameStartsWithIgnoreCase("Bauer")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}

}
