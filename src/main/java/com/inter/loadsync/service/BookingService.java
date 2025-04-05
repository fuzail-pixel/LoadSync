package com.inter.loadsync.service;

import com.inter.loadsync.dto.BookingDTO;
import com.inter.loadsync.dto.BookingResponseDTO;
import com.inter.loadsync.entity.*;
import com.inter.loadsync.repository.BookingRepository;
import com.inter.loadsync.repository.LoadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final LoadRepository loadRepository;

    @Transactional
    public BookingResponseDTO createBooking(BookingDTO dto) {
        Load load = loadRepository.findById(dto.getLoadId())
                .orElseThrow(() -> new RuntimeException("Load not found"));

        if (load.getStatus() == LoadStatus.CANCELLED) {
            throw new RuntimeException("Cannot book a cancelled load.");
        }

        Booking booking = Booking.builder()
                .load(load)
                .transporterId(dto.getTransporterId())
                .proposedRate(dto.getProposedRate())
                .comment(dto.getComment())
                .status(BookingStatus.REQUESTED)
                .build();

        bookingRepository.save(booking);

        // Optionally update load status (example: mark as BOOKED when first booking is created)
        load.setStatus(LoadStatus.BOOKED);
        loadRepository.save(load);

        return mapToResponse(booking);
    }

    public List<BookingResponseDTO> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    public BookingResponseDTO getBookingById(UUID id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return mapToResponse(booking);
    }

    @Transactional
    public BookingResponseDTO updateBooking(UUID id, BookingDTO dto) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setProposedRate(dto.getProposedRate());
        booking.setComment(dto.getComment());
        booking.setTransporterId(dto.getTransporterId());

        bookingRepository.save(booking);
        return mapToResponse(booking);
    }

    @Transactional
    public void deleteBooking(UUID id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Load load = booking.getLoad();
        bookingRepository.delete(booking);

        // Update load status to CANCELLED after booking deletion
        load.setStatus(LoadStatus.CANCELLED);
        loadRepository.save(load);
    }

    private BookingResponseDTO mapToResponse(Booking booking) {
        return BookingResponseDTO.builder()
                .id(booking.getId())
                .loadId(booking.getLoad().getId())
                .transporterId(booking.getTransporterId())
                .proposedRate(booking.getProposedRate())
                .comment(booking.getComment())
                .status(booking.getStatus())
                .requestedAt(booking.getRequestedAt())
                .build();
    }
}
