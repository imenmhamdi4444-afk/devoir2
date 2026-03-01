package com.imen.hotels.service;

import java.util.List;

import org.springframework.data.domain.Page;
import com.imen.hotels.entities.Hotel;

public interface HotelService {
	Hotel saveHotel(Hotel hotel); 
    Hotel updateHotel(Hotel hotel); 
    void deleteHotel(Hotel hotel); 
    void deleteHotelById(Long id); 
    Hotel getHotel(Long id); 
    List<Hotel> getAllHotels(); 
    Page<Hotel> getAllHotelsParPage(int page, int size);
}

