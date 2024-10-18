package com.example.food_store.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.food_store.service.ProductService;
import com.example.food_store.service.UserService;

@Controller
public class DashBoardController {
    private final UserService userService;
    private final ProductService productService;

    public DashBoardController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/admin")
    public String getDashBoard(Model model) {
        long countUser = this.userService.countUser();
        long countOrder = this.userService.countOrder();
        long countProduct = this.productService.countProduct();
        model.addAttribute("countUser", countUser);
        model.addAttribute("countOrder", countOrder);
        model.addAttribute("countProduct", countProduct);

        return "admin/dashboard/show";
    }

}
