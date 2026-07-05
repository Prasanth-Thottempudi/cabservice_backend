package com.nova.service;

import com.nova.dto.BookingRequest;
import com.nova.dto.BookingResponse;

public interface BookingService {

    BookingResponse createBooking(BookingRequest request);

    BookingResponse getBookingById(String bookingId);

    BookingResponse getBookingByNumber(String bookingNumber);

}