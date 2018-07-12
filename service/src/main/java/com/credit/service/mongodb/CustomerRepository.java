package com.credit.service.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer queryCustomer(String firstName);

    public List<Customer> queryByLastName(String lastName);
}
