package com.nova.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nova.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, String> {

    Optional<Booking> findByBookingId(String bookingId);

    boolean existsByBookingId(String bookingId);
    


    @Query(value = "SELECT nextval('booking_sequence')", nativeQuery = true)
    Long getNextBookingSequence();
    
    

}