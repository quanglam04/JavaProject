package com.example.food_store.controller;

import org.springframework.stereotype.Controller;
import com.example.food_store.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage() {
        return "hello";
    }

}
