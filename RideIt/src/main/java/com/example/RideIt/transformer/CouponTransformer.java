package com.example.RideIt.transformer;

import com.example.RideIt.model.Coupon;

public class CouponTransformer {
    public static Coupon prepareCoupon(String couponCode, int percentageDiscount){
        return Coupon.builder().couponCode(couponCode).percentageDiscount(percentageDiscount).
                build();
    }
}
