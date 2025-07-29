package com.example.ComboBox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ComboBox.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
