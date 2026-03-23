package com.example.Rockstargames.repository;

import com.example.Rockstargames.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
}
//hallo