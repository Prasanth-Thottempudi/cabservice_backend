package com.nova.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {

    private UUID customerId;

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private String email;

    private String gender;

    private LocalDate dateOfBirth;

    private String profilePhotoUrl;

    private Double walletBalance;

    private Double rating;

    private Integer totalRides;

    private Boolean verified;

    private Boolean active;

    private String referralCode;

    private String referredBy;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}