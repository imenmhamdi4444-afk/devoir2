package com.imen.hotels.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imen.hotels.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long > {

}
