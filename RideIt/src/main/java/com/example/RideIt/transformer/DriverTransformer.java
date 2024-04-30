package com.example.RideIt.transformer;

import com.example.RideIt.dto.requestDTO.DriverRequest;
import com.example.RideIt.dto.responseDTO.DriverResponse;
import com.example.RideIt.model.Driver;
import jakarta.persistence.Entity;
import lombok.Builder;

@Builder
public class DriverTransformer {

    public static Driver DriverRequestToDriver(DriverRequest driverRequest) {
        return Driver.builder().name(driverRequest.getName()).age(driverRequest.getAge())
                .mobNo(driverRequest.getMobNo()).panNumber(driverRequest.getPanNumber()).rating(0.0f).build();
    }

    public static DriverResponse driverToDriverResponse(Driver driver) {
        return DriverResponse.builder()
                .name(driver.getName())
                .rating(driver.getRating())
                .mobNo(driver.getMobNo())
                .cabResponse(CabTransformer.cabToCabResponse(driver.getCab()))
                .build();
    }
}
