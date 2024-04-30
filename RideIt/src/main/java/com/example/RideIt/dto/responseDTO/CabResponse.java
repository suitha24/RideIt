package com.example.RideIt.dto.responseDTO;

import com.example.RideIt.Enum.CarType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CabResponse {
    String cabNo;
    String carModel;
    double farePerKm;
}
