package com.imen.hotels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.imen.hotels.entities.Hotel;
import com.imen.hotels.entities.TypeHotel;
import com.imen.hotels.repos.TypeHotelRepository;
import com.imen.hotels.service.HotelService;

@SpringBootApplication
public class HotelsApplication implements CommandLineRunner {

    @Autowired
    HotelService hotelService;

    @Autowired
    TypeHotelRepository typeHotelRepository;

    public static void main(String[] args) {
        SpringApplication.run(HotelsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (hotelService.getAllHotels().isEmpty()) {

            TypeHotel luxe       = typeHotelRepository.findById(1L).orElse(null);
            TypeHotel economique = typeHotelRepository.findById(2L).orElse(null);
            TypeHotel resort     = typeHotelRepository.findById(3L).orElse(null);
            TypeHotel affaires   = typeHotelRepository.findById(4L).orElse(null);
            TypeHotel boutique   = typeHotelRepository.findById(5L).orElse(null);

            Hotel h1 = new Hotel("Neira Boutique Hotel & Spa", "Sidi Bousaid", 373.0, 4);
            h1.setTypeHotel(boutique);
            hotelService.saveHotel(h1);

            Hotel h2 = new Hotel("TUI BLUE Manar", "Hammamet", 1054.0, 5);
            h2.setTypeHotel(resort);
            hotelService.saveHotel(h2);

            Hotel h3 = new Hotel("Hotel Marhaba", "Sousse", 150.0, 4);
            h3.setTypeHotel(economique);
            hotelService.saveHotel(h3);

            Hotel h4 = new Hotel("Hotel Riu", "Tunis", 200.0, 5);
            h4.setTypeHotel(resort);
            hotelService.saveHotel(h4);

            Hotel h5 = new Hotel("Hotel Paradise", "Djerba", 180.0, 4);
            h5.setTypeHotel(economique);
            hotelService.saveHotel(h5);

            Hotel h6 = new Hotel("Hotel Royal", "Hammamet", 90.0, 3);
            h6.setTypeHotel(affaires);
            hotelService.saveHotel(h6);

            Hotel h7 = new Hotel("Royal Azur Thalassa", "Hammamet", 1165.0, 5);
            h7.setTypeHotel(resort);
            hotelService.saveHotel(h7);

            Hotel h8 = new Hotel("Dar El Medina", "Tunis", 380.0, 4);
            h8.setTypeHotel(boutique);
            hotelService.saveHotel(h8);
        }
    }
}