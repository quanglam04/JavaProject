package com.example.food_store.controller.client;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

    @RequestMapping("/")
    public String getHomePage() {
        return "client/homepage/show";
    }

}
