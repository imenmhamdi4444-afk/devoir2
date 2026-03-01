package com.imen.hotels;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import com.imen.hotels.entities.Hotel;
import com.imen.hotels.repos.HotelRepository;
import com.imen.hotels.service.HotelService;

@SpringBootTest
class HotelsApplicationTests {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private HotelService hotelService;

    @Test
    public void testCreateLuxuryHotel() {
        Hotel hotel = new Hotel("Burj Al Arab", "Dubai", 1500.000, 7);
        hotelRepository.save(hotel);
    }

    @Test
    public void testFindHotelById() {
        Hotel hotel = hotelRepository.findById(1L).get();
        System.out.println("Hotel found by ID: " + hotel);
    }

    @Test
    public void testUpdateHotel() {
        Hotel hotel = hotelRepository.findById(1L).get();
        hotel.setPrixNuit(300.0);
        hotelRepository.save(hotel);
    }

    @Test
    public void testDeleteHotel() {
        hotelRepository.deleteById(1L);
    }

    @Test
    public void testListAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        for (Hotel hotel : hotels) {
            System.out.println(hotel);
        }
    }

    @Test
    public void testGetAllHotelsParPage() {
        Page<Hotel> hotels = hotelService.getAllHotelsParPage(0, 2);
        System.out.println(hotels.getSize());
        System.out.println(hotels.getTotalElements());
        System.out.println(hotels.getTotalPages());
        hotels.getContent().forEach(h -> {
            System.out.println(h.toString());
        });
    }
}