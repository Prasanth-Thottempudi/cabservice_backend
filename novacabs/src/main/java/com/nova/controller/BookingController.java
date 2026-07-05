package com.nova.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.nova.dto.BookingRequest;
import com.nova.dto.BookingResponse;
import com.nova.service.BookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/bookings")
@Validated
public class BookingController {

    private final BookingService bookingService;
    
    

    public BookingController(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	@PostMapping
    public ResponseEntity<BookingResponse> createBooking(
            @Valid @RequestBody BookingRequest request) {

        BookingResponse response = bookingService.createBooking(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingResponse> getBookingById(
            @PathVariable UUID bookingId) {

        BookingResponse response =
                bookingService.getBookingById(bookingId.toString());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/number/{bookingNumber}")
    public ResponseEntity<BookingResponse> getBookingByNumber(
            @PathVariable String bookingNumber) {

        BookingResponse response =
                bookingService.getBookingByNumber(bookingNumber);

        return ResponseEntity.ok(response);
    }

}