package com.example.RideIt.service;

import com.example.RideIt.dto.requestDTO.TripBookingRequest;
import com.example.RideIt.dto.responseDTO.TripBookingResponse;
import com.example.RideIt.exception.CabNotAvailableException;
import com.example.RideIt.exception.CustomerNotFoundException;
import com.example.RideIt.model.Cab;
import com.example.RideIt.model.Coupon;
import com.example.RideIt.model.Customer;
import com.example.RideIt.model.TripBooking;
import com.example.RideIt.repository.*;
import com.example.RideIt.transformer.BookingTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripBookingService   {

    private final CustomerRepository customerRepository;
    private final CabRepository cabRepository;
    private final DriverRepository driverRepository;
    private final BookingRepository bookingRepository;
    private final CouponRepository couponRepository;
    public TripBookingResponse bookCab(boolean applyCoupon, TripBookingRequest tripBookingRequest){
        Coupon availableCoupon=new Coupon();
        //coupon
        if(applyCoupon){
            availableCoupon=couponRepository.getRandomAvailableCoupon();
        }
        //check if customer is valid user
        Customer customer= customerRepository.findByEmailId(tripBookingRequest.getEmailId());
        if(customer==null)
            throw  new CustomerNotFoundException("Invalid Email ID");

        //check if cab is available for booking
        //get a random cab that is available
        Cab cab=cabRepository.getRandomAvailableCab();
        if(cab==null)
            throw new CabNotAvailableException("Sorry! All our drivers are busy, Please try after some time");

        //prepare the booking entity
        TripBooking tripBooking= BookingTransformer.TripBookingRequestToTripBooking(tripBookingRequest);
        //calculate total fare
        if(!applyCoupon)
        {
            tripBooking.setTotalFare(cab.getFarePerKm()*tripBookingRequest.getTripDistanceInKm());
        }
        else{
            double totalFare=cab.getFarePerKm()*tripBookingRequest.getTripDistanceInKm();
            double totalFareAfterDiscount=totalFare-((availableCoupon.getPercentageDiscount()*totalFare)/100);
            tripBooking.setTotalFare(totalFareAfterDiscount);
        }

        tripBooking.setCustomer(customer);
        tripBooking.setDriver(cab.getDriver());

        //save the booking
        TripBooking savedBooking=bookingRepository.save(tripBooking);
        customer.getBookings().add(savedBooking);
        cab.getDriver().getBookings().add(savedBooking);
        cab.setAvailable(false);

        customerRepository.save(customer);
        driverRepository.save(cab.getDriver());

        TripBookingResponse tripBookingResponse=BookingTransformer.TripBookingToTripBookingResponse(savedBooking);
        return tripBookingResponse;
    }

    public String tripCompletion(String bookingId) {
        bookingRepository.updateTripStatus(bookingId);
        return "Your ride is completed! Hope you enjoyed!";
    }


    public void updateRating(String bookingId, float rating){
        int driverId=bookingRepository.getDriverId(bookingId);
        bookingRepository.updateRating(driverId,rating);
    }
}
