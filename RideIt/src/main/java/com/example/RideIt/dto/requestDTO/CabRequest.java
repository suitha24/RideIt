package com.example.RideIt.dto.requestDTO;

import com.example.RideIt.Enum.CarType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
public class CabRequest {

    String cabNo;
    String carModel;
    CarType carType;
    int numberOfSeats;
    double farePerKm;

}
