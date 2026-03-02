package com.imen.hotels.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.imen.hotels.entities.Hotel;
import com.imen.hotels.entities.TypeHotel;

public interface HotelService {
    Hotel saveHotel(Hotel hotel);
    Hotel updateHotel(Hotel hotel);
    void deleteHotel(Hotel hotel);
    void deleteHotelById(Long id);
    Hotel getHotel(Long id);
    List<Hotel> getAllHotels();
    Page<Hotel> getAllHotelsParPage(int page, int size);
    List<Hotel> findByNomHotel(String nom);
    List<Hotel> findByNomHotelContains(String nom);
    List<Hotel> findByNomPrix(String nom, Double prix);
    List<Hotel> findByNomPrixParam(String nom, Double prix);
    List<Hotel> findByTypeHotel(TypeHotel typeHotel);
    List<Hotel> findByTypeHotelIdType(Long id);
    List<Hotel> findByOrderByNomHotelAsc();
    List<Hotel> trierHotelsNomsPrix();
}