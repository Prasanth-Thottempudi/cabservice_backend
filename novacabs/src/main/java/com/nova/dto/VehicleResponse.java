package com.nova.dto;

import java.math.BigDecimal;
import java.util.UUID;

import com.nova.enums.VehicleCode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleResponse {

    private String  vehicleId;

    private VehicleCode vehicleCode;

    private String vehicleName;

    private String description;

    private BigDecimal baseFare;

    private BigDecimal pricePerKm;

    private BigDecimal driverAllowance;

    private Integer minimumKm;

    private Boolean active;


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

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

}