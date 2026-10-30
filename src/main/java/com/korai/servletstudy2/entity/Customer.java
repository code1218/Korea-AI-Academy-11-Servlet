package com.korai.servletstudy2.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int customerId;
    private String name;
    private String phone;
    private String email;
    private String birthDate;
    private String district;
    private String address;
    private String grade;
    private int marketingAgreed;
    private String joinedAt;
}

