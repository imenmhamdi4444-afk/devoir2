package com.imen.hotels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.imen.hotels.entities.Hotel;
import com.imen.hotels.service.HotelService;

@SpringBootApplication
public class HotelsApplication implements CommandLineRunner {

    @Autowired
    HotelService hotelService;

    public static void main(String[] args) {
        SpringApplication.run(HotelsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (hotelService.getAllHotels().isEmpty()) {
            hotelService.saveHotel(new Hotel("Hotel Marhaba", "Sousse", 150.0, 4));
            hotelService.saveHotel(new Hotel("Hotel Riu", "Tunis", 200.0, 5));
            hotelService.saveHotel(new Hotel("Hotel Novotel", "Sfax", 120.0, 3));
            hotelService.saveHotel(new Hotel("Hotel Paradise", "Djerba", 180.0, 4));
            hotelService.saveHotel(new Hotel("Hotel Royal", "Hammamet", 90.0, 3));
        }
    }
}