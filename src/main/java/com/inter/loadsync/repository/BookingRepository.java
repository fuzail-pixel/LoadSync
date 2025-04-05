package com.inter.loadsync.repository;

import com.inter.loadsync.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {

    List<Booking> findByTransporterId(String transporterId);

    List<Booking> findByLoad_Id(UUID loadId);

}
