package com.example.RideIt.controller;

import com.example.RideIt.dto.requestDTO.DriverRequest;
import com.example.RideIt.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/driver")

public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping("/add")
    public ResponseEntity<String> addDriver(@RequestBody DriverRequest driverRequest){

        String response=driverService.addDriver(driverRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
//    @PutMapping("/delete")
//    public ResponseEntity<String> deleteDriver(@RequestParam int age){
//        String response=driverService.deleteDriver(age);
//        return new ResponseEntity<>(response,HttpStatus.CREATED);
//    }
}
