package com.csb.appadvcmidterms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String index() {
        return "Home";
    }

    @GetMapping("/AboutUs")
    public String aboutUs() {
        return "About_Us";
    }

    @GetMapping("/Create")
    public String Create() {
        return "Appointment/Reservation";
    }
}
