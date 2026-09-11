package com.bank.system.banksystem.service;

import com.bank.system.banksystem.dto.CustomerCreateRequest;
import com.bank.system.banksystem.dto.CustomerResponse;
import com.bank.system.banksystem.dto.CustomerUpdateRequest;
import com.bank.system.banksystem.entity.Customer;

import java.util.List;

public interface CustomerService {

    CustomerResponse createCustomer(CustomerCreateRequest request);

    List<Customer> getAllCustomers();

    CustomerResponse updateCustomer(Long id, CustomerUpdateRequest request);

    void deleteCustomer(Long id);

    List<CustomerResponse> getAllDeletedCustomers();
}
