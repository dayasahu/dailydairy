package com.dailydairy.delivery;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.dailydairy.delivery.entity.Customer;
import com.dailydairy.delivery.service.CustomerService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
public class DailydairyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailydairyApplication.class, args);
	}

	@Autowired
	private CustomerService customerService;

	@Bean
	public Function<String, String> function() {

		return input -> input;
	}

	@Bean
	public Consumer<String> consumer() {
		return input -> System.out.println("input: " + input);

	}

	@Bean
	public Supplier<List<Customer>> customers() {
		return () -> customerService.findAll();
	}
}
