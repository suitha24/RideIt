package com.example.RideIt.controller;

import com.example.RideIt.Enum.Gender;
import com.example.RideIt.dto.requestDTO.CustomerRequest;
import com.example.RideIt.dto.responseDTO.CustomerResponse;
import com.example.RideIt.service.CustomerService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping
    public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerRequest customerRequest){
        CustomerResponse response = customerService.addCustomer(customerRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}