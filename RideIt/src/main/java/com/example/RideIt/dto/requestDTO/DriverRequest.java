package com.example.RideIt.dto.requestDTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DriverRequest {
    String name;

    int age;

    String panNumber;

    String mobNo;

    float rating;

    CabRequest cab;

}
