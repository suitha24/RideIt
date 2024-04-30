package com.example.RideIt.controller;

import com.example.RideIt.dto.requestDTO.TripBookingRequest;
import com.example.RideIt.dto.responseDTO.TripBookingResponse;
import com.example.RideIt.service.TripBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bookCab")

public class TripBookingController {

    private final TripBookingService tripBookingService;

    @PostMapping("/book")
    public ResponseEntity<TripBookingResponse> bookCab(@RequestParam(value = "apply-coupon",
            required = false, defaultValue = "false") boolean applyCoupon,@RequestBody TripBookingRequest tripBookingRequest) {
        TripBookingResponse response = tripBookingService.bookCab(applyCoupon,tripBookingRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/rideCompleted")
    public ResponseEntity<String> tripCompletion(@RequestParam String bookingId,@RequestParam(value="rate_driver",required = false) float rating){

        //update rating
        tripBookingService.updateRating(bookingId,rating);
        //update trip status
        String response=tripBookingService.tripCompletion(bookingId);

        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}