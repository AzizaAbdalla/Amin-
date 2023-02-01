package com.example.online_backend.controller;


import com.example.online_backend.model.Hotel;
import com.example.online_backend.repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.PublicKey;
import java.util.List;

@Controller
public class HotelController {

    @Autowired
    private HotelRepo hotelRepo;


    @GetMapping({"/index","/"})
    public ModelAndView getMyPage(){
        ModelAndView modelAndView = new ModelAndView("MICHO");
        Hotel hotel = new Hotel();
        modelAndView.addObject("hotel",hotel);
        return modelAndView;
    }
    @GetMapping("/Reg")
    public ModelAndView getPage(){
        ModelAndView modelAndView = new ModelAndView("hote");
        Hotel  hotel = new Hotel();
        modelAndView.addObject("myAZIZA",hotel);
        return modelAndView;
    }

/*
    @GetMapping("/showhotel")
    public ModelAndView showhotel(){
        ModelAndView modelAndView = new ModelAndView("customert");
        Hotel hotel = new Hotel();
        modelAndView.addObject("aziza",hotel);
        return modelAndView;
    }


 */
    @GetMapping("/table")
    public ModelAndView showdata(){
        ModelAndView aziza = new ModelAndView("customert");
        List<Hotel> list = hotelRepo.findAll();
        aziza.addObject("az",list);
        return aziza;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int hotel_id){
        hotelRepo.deleteById(hotel_id);
        return "redirect:/table";
    }

    @PostMapping("/saveHolel")
    public String saveHolel(@ModelAttribute Hotel hotel){
        hotelRepo.save(hotel);
        return "redirect:/table";
    }
}
