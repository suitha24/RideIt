package com.example.RideIt.exception;

import com.example.RideIt.dto.responseDTO.TripBookingResponse;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message){
        super(message);
    }
}
