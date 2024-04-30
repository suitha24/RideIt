package com.example.RideIt.controller;

import com.example.RideIt.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/v1/coupon")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

//    public CouponController(CouponService couponService) {
//        this.couponService = couponService;
//    }

    @PostMapping
    public ResponseEntity<String> addCoupon(@RequestParam String couponCode,int percentageDiscount){
        String response=couponService.addCoupon(couponCode,percentageDiscount);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
