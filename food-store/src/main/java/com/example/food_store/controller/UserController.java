package com.example.food_store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.food_store.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/web")
public class UserController {
    @Autowired
    private UserService userService;



    @GetMapping("/home")
    public ModelAndView getHomePage() {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @GetMapping("/register")
    public ModelAndView registerPage() {
        ModelAndView mav = new ModelAndView("register");
        return mav;
    }

}
