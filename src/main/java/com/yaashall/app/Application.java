package com.yaashall.app;

import com.yaashall.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
@description Managing stock product orders customers

 entities : Stock, Product, Orders, Customers, CustomerIdCard,

 Stock is a container of products
 a customer could order many orders
 an order can care many products

 simple user interface
 login customer
 admin page
 dashboard
 security
 Monolithic + MVC

 ....

@author Yassine CHALH
 */


/*
@ComponentScan(basePackages = "com.yaashall")
@EnableAutoConfiguration
@Configuration
*/


@SpringBootApplication
@ComponentScan({"com.yaashall.controller", "com.yaashall.service"})
@EntityScan("com.yaashall.entity")
@EnableJpaRepositories("com.yaashall.repository")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }






/*
 */
}
