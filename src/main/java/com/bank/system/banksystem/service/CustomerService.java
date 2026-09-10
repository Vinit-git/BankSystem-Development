package com.bank.system.banksystem.service;

import com.bank.system.banksystem.entity.Customer;
import com.bank.system.banksystem.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        Customer customer =  customerRepository.getReferenceById(id);
        customer.setDeleted(true);
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> getAllDeletedCustomers() {
        return customerRepository.findAllDeletedCustomers();
    }

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

}
