package com.example.RideIt.service;

import com.example.RideIt.dto.requestDTO.CabRequest;
import com.example.RideIt.dto.requestDTO.DriverRequest;
import com.example.RideIt.model.Cab;
import com.example.RideIt.model.Driver;
import com.example.RideIt.repository.DriverRepository;
import com.example.RideIt.transformer.CabTransformer;
import com.example.RideIt.transformer.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;
    public String addDriver(DriverRequest driverRequest){

        CabRequest cabRequest=driverRequest.getCab();

        //driverRequest --> Driver
        //cabRequest --> cab
        Driver driver= DriverTransformer.DriverRequestToDriver(driverRequest);
        Cab cab= CabTransformer.CabRequestToCab(cabRequest);

        //set the relationship attributes
        cab.setDriver(driver);
        driver.setCab(cab);

        //we need to save both driver & cab in db
        //as we added cascade to cab attribute in driver class, cab details will be automatically saved in db when we save driver details
        driverRepository.save(driver);

        return "Driver and Cab details saved successfully";
    }

//    public String deleteDriver(int age){
//      Driver driver1=driverRepository.findDriverByAge(age);
//        int id=driver1.getId();
//        driverRepository.deleteCab(id);
//        driverRepository.deleteDriver(age);
//        return "Driver details & associated cab details are deleted successfully";
//    }
}
