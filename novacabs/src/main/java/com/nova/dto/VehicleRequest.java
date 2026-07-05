package com.nova.dto;

import java.math.BigDecimal;

import com.nova.enums.VehicleCode;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleRequest {

    @NotNull
    private VehicleCode vehicleCode;

    @NotBlank
    private String vehicleName;

    private String description;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal baseFare;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal pricePerKm;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal driverAllowance;

    @NotNull
    private Integer minimumKm;

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

}