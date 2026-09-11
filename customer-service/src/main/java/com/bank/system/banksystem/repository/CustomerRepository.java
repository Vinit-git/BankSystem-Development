package com.bank.system.banksystem.repository;

import com.bank.system.banksystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository  extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT * FROM customer WHERE is_deleted = true",
            nativeQuery = true)
    List<Customer> findAllDeletedCustomers();
}
