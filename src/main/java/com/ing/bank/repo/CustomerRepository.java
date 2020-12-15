package com.ing.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.bank.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
