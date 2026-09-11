package com.bank.system.banksystem.mapper;

import com.bank.system.banksystem.dto.CustomerResponse;
import com.bank.system.banksystem.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper {

    public CustomerResponse mapToResponse(Customer customer) {

        CustomerResponse response = new CustomerResponse();

        response.setId(customer.getId());
        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());
        response.setEmail(customer.getEmail());
        response.setPhone(customer.getPhone());
        response.setDateOfBirth(customer.getDateOfBirth());
        response.setCreatedAt(customer.getCreatedAt());

        return response;
    }

    public List<CustomerResponse> mapToResponseList(List<Customer> customers) {
        List<CustomerResponse> responseList;
        responseList = customers.stream().map(this::mapToResponse).toList();
        return responseList;
    }
}
