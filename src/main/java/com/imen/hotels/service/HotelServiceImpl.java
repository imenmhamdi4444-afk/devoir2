package com.imen.hotels.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.imen.hotels.entities.Hotel;
import com.imen.hotels.entities.TypeHotel;
import com.imen.hotels.repos.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotel(Hotel hotel) {
        hotelRepository.delete(hotel);
    }

    @Override
    public void deleteHotelById(Long id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public Hotel getHotel(Long id) {
        return hotelRepository.findById(id).get();
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Page<Hotel> getAllHotelsParPage(int page, int size) {
        return hotelRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Hotel> findByNomHotel(String nom) {
        return hotelRepository.findByNomHotel(nom);
    }

    @Override
    public List<Hotel> findByNomHotelContains(String nom) {
        return hotelRepository.findByNomHotelContains(nom);
    }

    @Override
    public List<Hotel> findByNomPrix(String nom, Double prix) {
        return hotelRepository.findByNomPrix(nom, prix);
    }

    @Override
    public List<Hotel> findByNomPrixParam(String nom, Double prix) {
        return hotelRepository.findByNomPrixParam(nom, prix);
    }

    @Override
    public List<Hotel> findByTypeHotel(TypeHotel typeHotel) {
        return hotelRepository.findByTypeHotel(typeHotel);
    }

    @Override
    public List<Hotel> findByTypeHotelIdType(Long id) {
        return hotelRepository.findByTypeHotelIdType(id);
    }

    @Override
    public List<Hotel> findByOrderByNomHotelAsc() {
        return hotelRepository.findByOrderByNomHotelAsc();
    }

    @Override
    public List<Hotel> trierHotelsNomsPrix() {
        return hotelRepository.trierHotelsNomsPrix();
    }
}