package com.dev.spring.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.spring.batch.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

