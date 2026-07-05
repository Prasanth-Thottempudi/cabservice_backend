package com.nova.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "customer_id", nullable = false, updatable = false)
    private UUID customerId;

    @Column(name = "customer_number", unique = true, nullable = false)
    private String customerNumber;
    
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "mobile_number", nullable = false, unique = true, length = 10)
    private String mobileNumber;

    @Column(name = "email", unique = true, length = 100)
    private String email;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "profile_photo_url")
    private String profilePhotoUrl;

    @Column(name = "wallet_balance")
    @Builder.Default
    private Double walletBalance = 0.0;

    @Column(name = "rating")
    @Builder.Default
    private Double rating = 0.0;

    @Column(name = "total_rides")
    @Builder.Default
    private Integer totalRides = 0;

    @Column(name = "is_verified")
    @Builder.Default
    private Boolean verified = false;

    @Column(name = "is_active")
    @Builder.Default
    private Boolean active = true;

    @Column(name = "referral_code", unique = true)
    private String referralCode;

    @Column(name = "referred_by")
    private String referredBy;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

	public UUID getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getProfilePhotoUrl() {
		return profilePhotoUrl;
	}

	public void setProfilePhotoUrl(String profilePhotoUrl) {
		this.profilePhotoUrl = profilePhotoUrl;
	}

	public Double getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(Double walletBalance) {
		this.walletBalance = walletBalance;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getTotalRides() {
		return totalRides;
	}

	public void setTotalRides(Integer totalRides) {
		this.totalRides = totalRides;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getReferralCode() {
		return referralCode;
	}

	public void setReferralCode(String referralCode) {
		this.referralCode = referralCode;
	}

	public String getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

    
    
}