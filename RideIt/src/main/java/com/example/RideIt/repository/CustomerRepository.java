package com.example.RideIt.repository;

import com.example.RideIt.Enum.Gender;
import com.example.RideIt.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer where email_id=:emailId",nativeQuery = true)
    public Customer findByEmailId(String emailId);
}
