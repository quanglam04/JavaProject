package com.example.food_store.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
    @GetMapping("/admin/order")
    public String getDashBoard() {
        return "admin/order/show";
    }

}
