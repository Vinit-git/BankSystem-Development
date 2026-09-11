package com.bank.system.banksystem.service;

import com.bank.system.banksystem.dto.CustomerCreateRequest;
import com.bank.system.banksystem.dto.CustomerResponse;
import com.bank.system.banksystem.dto.CustomerUpdateRequest;
import com.bank.system.banksystem.entity.Customer;
import com.bank.system.banksystem.mapper.CustomerMapper;
import com.bank.system.banksystem.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerResponse createCustomer(CustomerCreateRequest customer) {
       Customer newCustomer = new Customer();
        newCustomer.setFirstName(customer.getFirstName());
        newCustomer.setLastName(customer.getLastName());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setDateOfBirth(customer.getDateOfBirth());
        newCustomer.setPasswordHash(customer.getPasswordHash());
       Customer response = customerRepository.save(newCustomer);
        return customerMapper.mapToResponse(response);
    }

    public void deleteCustomer(Long id) {
        Customer customer =  customerRepository.getReferenceById(id);
        customer.setDeleted(true);
        customerRepository.save(customer);
    }

    public CustomerResponse updateCustomer(Long id, CustomerUpdateRequest updateCustomer) {

        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        existingCustomer.setFirstName(updateCustomer.getFirstName());
        existingCustomer.setLastName(updateCustomer.getLastName());
        existingCustomer.setEmail(updateCustomer.getEmail());
        existingCustomer.setPhone(updateCustomer.getPhone());
        existingCustomer.setDateOfBirth(updateCustomer.getDateOfBirth());
        Customer updatedCustomer = customerRepository.save(existingCustomer);
        return customerMapper.mapToResponse(updatedCustomer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<CustomerResponse> getAllDeletedCustomers() {
        return customerMapper.mapToResponseList(customerRepository.findAllDeletedCustomers());
    }

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

}
