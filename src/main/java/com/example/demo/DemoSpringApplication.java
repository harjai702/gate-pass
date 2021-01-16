package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses =userrepo.class)
public class DemoSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringApplication.class, args);
    }

}
