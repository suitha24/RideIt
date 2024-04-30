package com.example.RideIt.transformer;

import com.example.RideIt.dto.requestDTO.CustomerRequest;
import com.example.RideIt.dto.responseDTO.CustomerResponse;
import com.example.RideIt.model.Customer;

public class CustomerTransformer {
    public static Customer CustomerRequestToCustomer(CustomerRequest customerRequest){
        return Customer.builder().name(customerRequest.getName())
                .age(customerRequest.getAge()).emailId(customerRequest.getEmailId())
                .gender(customerRequest.getGender()).address(customerRequest.getAddress()).build();
    }

    public static CustomerResponse CustomerToCustomerResponse(Customer customer){
        return CustomerResponse.builder().name(customer.getName()).emailId(customer.getEmailId()).build();
    }
}
