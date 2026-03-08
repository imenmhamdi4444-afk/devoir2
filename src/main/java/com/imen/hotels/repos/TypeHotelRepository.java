package com.imen.hotels.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.imen.hotels.entities.TypeHotel;

public interface TypeHotelRepository extends JpaRepository<TypeHotel, Long> {
}