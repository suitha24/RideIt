package com.example.RideIt.transformer;

import com.example.RideIt.dto.requestDTO.CabRequest;
import com.example.RideIt.dto.responseDTO.CabResponse;
import com.example.RideIt.model.Cab;

public class CabTransformer {

    public static Cab CabRequestToCab(CabRequest cabRequest){
         return Cab.builder().cabNo(cabRequest.getCabNo()).carType(cabRequest.getCarType())
                 .carModel(cabRequest.getCarModel()).farePerKm(cabRequest.getFarePerKm())
                 .available(true).numberOfSeats(cabRequest.getNumberOfSeats()).build();
    }
    public static CabResponse cabToCabResponse(Cab cab){
        return CabResponse.builder()
                .cabNo(cab.getCabNo())
                .carModel(cab.getCarModel())
                .farePerKm(cab.getFarePerKm())
                .build();
    }
}
