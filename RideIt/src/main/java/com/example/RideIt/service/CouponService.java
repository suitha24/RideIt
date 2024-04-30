package com.example.RideIt.service;

import com.example.RideIt.model.Coupon;
import com.example.RideIt.repository.CouponRepository;
import com.example.RideIt.transformer.CouponTransformer;
import org.springframework.stereotype.Service;

@Service
public class CouponService {

    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }
    //Coupon coupon=new Coupon();
    public String addCoupon(String couponCode, int percentageDiscount) {
      //  Coupon coupon=CouponTransformer.prepareCoupon(couponCode,percentageDiscount);
        Coupon coupon=new Coupon(couponCode,percentageDiscount);
        couponRepository.save(coupon);
        return "Coupon added successfully";
    }
}
