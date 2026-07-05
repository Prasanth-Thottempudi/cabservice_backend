package com.nova.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.nova.enums.VehicleCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
public class Vehicle {

    @Id
    @Column(name = "vehicle_id", nullable = false, unique = true, length = 20)
    private String vehicleId;

    @Column(name = "vehicle_sequence", nullable = false, unique = true)
    private Long vehicleSequence;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private VehicleCode vehicleCode;

    @Column(nullable = false)
    private String vehicleName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal baseFare;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal pricePerKm;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal driverAllowance;

    @Column(nullable = false)
    private Integer minimumKm;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private LocalDateTime updatedDate;

    @PrePersist
    public void prePersist() {

        createdDate = LocalDateTime.now();
        updatedDate = LocalDateTime.now();

        if (active == null) {
            active = true;
        }
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = LocalDateTime.now();
    }

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Long getVehicleSequence() {
		return vehicleSequence;
	}

	public void setVehicleSequence(Long vehicleSequence) {
		this.vehicleSequence = vehicleSequence;
	}

	public VehicleCode getVehicleCode() {
		return vehicleCode;
	}

	public void setVehicleCode(VehicleCode vehicleCode) {
		this.vehicleCode = vehicleCode;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getBaseFare() {
		return baseFare;
	}

	public void setBaseFare(BigDecimal baseFare) {
		this.baseFare = baseFare;
	}

	public BigDecimal getPricePerKm() {
		return pricePerKm;
	}

	public void setPricePerKm(BigDecimal pricePerKm) {
		this.pricePerKm = pricePerKm;
	}

	public BigDecimal getDriverAllowance() {
		return driverAllowance;
	}

	public void setDriverAllowance(BigDecimal driverAllowance) {
		this.driverAllowance = driverAllowance;
	}

	public Integer getMinimumKm() {
		return minimumKm;
	}

	public void setMinimumKm(Integer minimumKm) {
		this.minimumKm = minimumKm;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
    
    
}