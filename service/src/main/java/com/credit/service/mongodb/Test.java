package com.credit.service.mongodb;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Configuration
public class Test {

    @Autowired
    private CustomerRepository repository;

    @Bean
    public Customer get() {
        List<Customer> l = repository.findAll();

        System.out.println("8888888888" + new Gson().toJson(l));

        return new Customer();
    }
}
