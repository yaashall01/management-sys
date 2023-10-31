package com.yaashall.repository;

import com.yaashall.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository
        extends JpaRepository<Customer, Long> {
}
