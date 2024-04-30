package com.example.RideIt.service;

import com.example.RideIt.dto.requestDTO.CustomerRequest;
import com.example.RideIt.dto.responseDTO.CustomerResponse;
import com.example.RideIt.model.Customer;
import com.example.RideIt.repository.CustomerRepository;
import com.example.RideIt.transformer.CustomerTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    //private final CustomerTransformer customerTransformer;

    public CustomerResponse addCustomer(CustomerRequest customerRequest){

        //CustomerRequest --> Customer
        Customer customer= CustomerTransformer.CustomerRequestToCustomer(customerRequest);

        Customer savedCustomer=customerRepository.save(customer);

        //Customer --> CustomerResponse
        return CustomerTransformer.CustomerToCustomerResponse(savedCustomer);
        //it's good practice to use saved customer in db instead of using input customer

    }
}
