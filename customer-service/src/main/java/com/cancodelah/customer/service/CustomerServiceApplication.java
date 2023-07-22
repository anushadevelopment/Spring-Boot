package com.cancodelah.customer.service;

import com.cancodelah.customer.service.dto.CustomerDto;
import com.cancodelah.customer.service.dto.CustomerMapper;
import com.cancodelah.customer.service.entity.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}




}
