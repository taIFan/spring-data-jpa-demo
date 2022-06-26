package com.simplilearn.springdatajpademo;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@SpringBootApplication
@ComponentScan(basePackages = "com.simplilearn.springdatajpademo.*")
public class SpringDataJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaDemoApplication.class, args);
	}


}
