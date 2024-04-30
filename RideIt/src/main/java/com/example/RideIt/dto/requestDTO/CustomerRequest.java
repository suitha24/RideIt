package com.example.RideIt.dto.requestDTO;
import com.example.RideIt.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerRequest {
    String name;
    int age;
    String emailId;
    String address;
    Gender gender;
}