package com.cancodelah.books;

import com.cancodelah.books.vo.ResponseTemplateVO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BooksServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate responseTemplate(){
		return new RestTemplate();
	}
}
