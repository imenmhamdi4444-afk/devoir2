package com.imen.hotels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.imen.hotels.entities.Hotel;
import com.imen.hotels.service.HotelService;

@Controller
public class HotelController {

    @Autowired
    HotelService hotelService;

    @RequestMapping("/ListeHotels")
    public String listeHotels(ModelMap modelMap,
            @RequestParam(name="page", defaultValue="0") int page,
            @RequestParam(name="size", defaultValue="2") int size) {
        Page<Hotel> hotels = hotelService.getAllHotelsParPage(page, size);
        modelMap.addAttribute("hotels", hotels);
        modelMap.addAttribute("pages", new int[hotels.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeHotels";
    }

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createHotel";
    }

    @RequestMapping("/saveHotel")
    public String saveHotel(@ModelAttribute("hotel") Hotel hotel, ModelMap modelMap) {
        Hotel savedHotel = hotelService.saveHotel(hotel);
        String msg = "Hotel enregistré avec Id " + savedHotel.getIdHotel();
        modelMap.addAttribute("msg", msg);
        return "createHotel";
    }

    @RequestMapping("/supprimerHotel")
    public String supprimerHotel(@RequestParam("id") Long id,
            ModelMap modelMap,
            @RequestParam(name="page", defaultValue="0") int page,
            @RequestParam(name="size", defaultValue="2") int size) {
        hotelService.deleteHotelById(id);
        Page<Hotel> hotels = hotelService.getAllHotelsParPage(page, size);
        modelMap.addAttribute("hotels", hotels);
        modelMap.addAttribute("pages", new int[hotels.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeHotels";
    }

    @RequestMapping("/modifierHotel")
    public String editerHotel(@RequestParam("id") Long id, ModelMap modelMap) {
        Hotel h = hotelService.getHotel(id);
        modelMap.addAttribute("hotel", h);
        return "editerHotel";
    }

    @RequestMapping("/updateHotel")
    public String updateHotel(@ModelAttribute("hotel") Hotel hotel, ModelMap modelMap) {
        hotelService.updateHotel(hotel);
        List<Hotel> hotels = hotelService.getAllHotels();
        modelMap.addAttribute("hotels", hotels);
        return "listeHotels";
    }
}