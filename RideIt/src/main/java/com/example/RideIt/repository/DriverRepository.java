package com.example.RideIt.repository;

import com.example.RideIt.model.Driver;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

////    @Query(value = "select id,age from driver where age=:age",nativeQuery = true)
////    public Driver findDriverByAge(int age);
//
//    @Transactional
//    @Modifying
//    @Query(value = "Delete from cab where driver_id=:id",nativeQuery = true)
//    public void deleteCab(int id);
//    @Transactional
//    @Modifying
//    @Query(value = "Delete from driver where age=:age",nativeQuery = true)
//    public void deleteDriver(int age);

}
