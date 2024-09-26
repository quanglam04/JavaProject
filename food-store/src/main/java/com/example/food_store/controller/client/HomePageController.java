package com.example.food_store.controller.client;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import com.example.food_store.domain.User;
import com.example.food_store.service.UserService;

@Controller
public class HomePageController {

    private final UserService userService;

    public HomePageController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage() {
        List<User> arrUser = this.userService.getAllUsersByEmail("trinhquanglam2k4@gmail.com");
        System.out.println(arrUser);
        return "client/homepage/show";
    }

}
