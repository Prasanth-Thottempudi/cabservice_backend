package com.nova.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequest {

    @NotBlank(message = "First Name is required")
    @Size(max = 50, message = "First Name cannot exceed 50 characters")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    @Size(max = 50, message = "Last Name cannot exceed 50 characters")
    private String lastName;

    @NotBlank(message = "Mobile Number is required")
    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Invalid Mobile Number"
    )
    private String mobileNumber;

    @Email(message = "Invalid Email")
    @Size(max = 100)
    private String email;

    @Pattern(
            regexp = "Male|Female|Other",
            message = "Gender must be Male, Female or Other"
    )
    private String gender;

    @Past(message = "Date of Birth must be in the past")
    private LocalDate dateOfBirth;

}