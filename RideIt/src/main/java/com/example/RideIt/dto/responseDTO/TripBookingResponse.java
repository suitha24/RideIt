package com.example.RideIt.dto.responseDTO;

import com.example.RideIt.Enum.TripStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TripBookingResponse {
    String bookingId;
    String pickup;

    String destination;

    double tripDistanceInKm;

    double totalFare;

    TripStatus tripStatus;

    Date bookedAt;

    DriverResponse driverResponse;
    CustomerResponse customerResponse;
    //Cab Response is  within Driver, so no need to add separately

}
