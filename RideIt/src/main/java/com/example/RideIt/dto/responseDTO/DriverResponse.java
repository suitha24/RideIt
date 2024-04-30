package com.example.RideIt.dto.responseDTO;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DriverResponse {
    String name;

    String mobNo;

    float rating;

    CabResponse cabResponse;

}
