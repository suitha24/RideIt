package com.example.RideIt.repository;

import com.example.RideIt.model.TripBooking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<TripBooking,Integer> {

    @Transactional
    @Modifying
    @Query(value = "update trip_booking set trip_status='COMPLETED' where booking_id=:bookingId",nativeQuery = true)
    void updateTripStatus(String bookingId);

    @Query(value = "select driver_id from trip_booking where booking_id=:bookingId",nativeQuery = true)
    int getDriverId(String bookingId);

    @Transactional
    @Modifying
    @Query(value = "update driver set rating=:rating where id=:driverId",nativeQuery = true)
    void updateRating(int driverId, float rating);
}
