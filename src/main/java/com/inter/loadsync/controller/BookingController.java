package com.inter.loadsync.controller;

import com.inter.loadsync.dto.BookingDTO;
import com.inter.loadsync.dto.BookingResponseDTO;
import com.inter.loadsync.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.ok(bookingService.createBooking(bookingDTO));
    }

    @GetMapping
    public ResponseEntity<List<BookingResponseDTO>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> getBookingById(@PathVariable UUID id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> updateBooking(@PathVariable UUID id, @RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.ok(bookingService.updateBooking(id, bookingDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable UUID id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }

    // Optional filters if needed
    @GetMapping("/transporter/{transporterId}")
    public ResponseEntity<List<BookingResponseDTO>> getBookingsByTransporter(@PathVariable String transporterId) {
        return ResponseEntity.ok(bookingService.getAllBookings().stream()
                .filter(b -> b.getTransporterId().equals(transporterId))
                .toList());
    }

    @GetMapping("/load/{loadId}")
    public ResponseEntity<List<BookingResponseDTO>> getBookingsByLoad(@PathVariable UUID loadId) {
        return ResponseEntity.ok(bookingService.getAllBookings().stream()
                .filter(b -> b.getLoadId().equals(loadId))
                .toList());
    }
}
