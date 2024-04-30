package com.example.RideIt.dto.requestDTO;

import com.example.RideIt.Enum.TripStatus;
import com.example.RideIt.model.Customer;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TripBookingRequest {
    String pickup;

    String destination;

    double tripDistanceInKm;

    String emailId;
}
