package com.bank.system.banksystem.service;

import com.bank.system.banksystem.entity.Customer;
import com.bank.system.banksystem.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

}
