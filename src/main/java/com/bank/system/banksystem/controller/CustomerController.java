package com.bank.system.banksystem.controller;

import com.bank.system.banksystem.dto.CustomerCreateRequest;
import com.bank.system.banksystem.dto.CustomerResponse;
import com.bank.system.banksystem.dto.CustomerUpdateRequest;
import com.bank.system.banksystem.entity.Customer;
import com.bank.system.banksystem.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/createCustomer")
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerCreateRequest customer) {
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.OK).body("Customer deleted successfully");
    }

    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<CustomerResponse>updateCustomer(@PathVariable Long id, @RequestBody CustomerUpdateRequest customer) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }

    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/getAllDeletedCustomers")
    public List<CustomerResponse> getAllDeletedCustomers() {
        return customerService.getAllDeletedCustomers();
    }

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
}
