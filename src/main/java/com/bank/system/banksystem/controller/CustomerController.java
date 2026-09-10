package com.bank.system.banksystem.controller;

import com.bank.system.banksystem.entity.Customer;
import com.bank.system.banksystem.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/createcustomer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
}
