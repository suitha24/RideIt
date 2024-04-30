package com.example.RideIt.transformer;

import com.example.RideIt.Enum.TripStatus;
import com.example.RideIt.dto.requestDTO.TripBookingRequest;
import com.example.RideIt.dto.responseDTO.TripBookingResponse;
import com.example.RideIt.model.TripBooking;

import java.util.UUID;

public class BookingTransformer {

    public static TripBooking TripBookingRequestToTripBooking(TripBookingRequest tripBookingRequest){
        return TripBooking.builder().bookingId(String.valueOf(UUID.randomUUID()))
                .pickup(tripBookingRequest.getPickup()).destination(tripBookingRequest.getDestination())
                .tripDistanceInKm(tripBookingRequest.getTripDistanceInKm()).tripStatus(TripStatus.IN_TRANSIT)
                .build();
    }
    public static TripBookingResponse TripBookingToTripBookingResponse(TripBooking tripBooking){
        return TripBookingResponse.builder().bookingId(tripBooking.getBookingId()).pickup(tripBooking.getPickup())
                .destination(tripBooking.getDestination()).tripDistanceInKm(tripBooking.getTripDistanceInKm())
                .tripStatus(tripBooking.getTripStatus()).bookedAt(tripBooking.getBookedAt())
                .driverResponse(DriverTransformer.driverToDriverResponse(tripBooking.getDriver()))
                .customerResponse(CustomerTransformer.CustomerToCustomerResponse(tripBooking.getCustomer()))
                 .totalFare(tripBooking.getTotalFare()).build();
    }
}
