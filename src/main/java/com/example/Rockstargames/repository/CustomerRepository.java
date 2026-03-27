package com.example.Rockstargames.repository;

import com.example.Rockstargames.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByName(String name);
    Optional<Customer> findByEmail(String email);
}