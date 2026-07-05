package com.nova.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nova.entity.Vehicle;
import com.nova.enums.VehicleCode;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

    boolean existsByVehicleCode(VehicleCode vehicleCode);

    List<Vehicle> findByActiveTrue();

    @Query(value = "SELECT nextval('vehicle_sequence')", nativeQuery = true)
    Long getNextVehicleSequence();
    
    Optional<Vehicle> findByVehicleCode(VehicleCode vehicleCode);
    

}