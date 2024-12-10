package com.luxevision.backend.controller;

import com.luxevision.backend.dto.*;
import com.luxevision.backend.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/quote")
    public ResponseEntity<QuotationResponse> quotation(@RequestBody @Valid QuotationRequest quotationRequest) {
        return ResponseEntity.ok(bookingService.quoteBooking(quotationRequest));
    }

    @PostMapping
    public ResponseEntity<?> saveBooking (@RequestBody @Valid SaveBooking booking) {
        return ResponseEntity.ok(bookingService.saveBooking(booking));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponse> findBookingById (@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.findOneBookingById(id));
    }

    @GetMapping
    public ResponseEntity<List<BookingResponse>> findAllBookings () {
        return ResponseEntity.ok(bookingService.findAllBookings());
    }

    @GetMapping("/from-today")
    public ResponseEntity<List<BookingResponse>> findAllBookingsFromToday () {
        return ResponseEntity.ok(bookingService.findAllBookingsFromTodayOnwards());
    }

    @GetMapping("/studio/{id}")
    public ResponseEntity<List<BookingResponse>> findAllBookingsByStudioId (@PathVariable Integer id) {
        return ResponseEntity.ok(bookingService.findAllBookingsByStudioId(id));
    }

    @GetMapping("/studio/{id}/from-today")
    public ResponseEntity<List<BookingResponse>> findAllBookingsByStudioIdFromToday (@PathVariable Integer id) {
        return ResponseEntity.ok(bookingService.findAllBookingsByStudioFromTodayOnwards(id));
    }


}
