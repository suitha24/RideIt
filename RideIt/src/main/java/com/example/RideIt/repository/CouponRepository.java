package com.example.RideIt.repository;

import com.example.RideIt.model.Cab;
import com.example.RideIt.model.Coupon;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CouponRepository extends JpaRepository<Coupon,Integer> {
@Query(value = "select * from coupon order by rand() limit 1",nativeQuery = true)
 Coupon getRandomAvailableCoupon();


}
