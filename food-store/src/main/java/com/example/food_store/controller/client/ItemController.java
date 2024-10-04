package com.example.food_store.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.food_store.domain.Cart;
import com.example.food_store.domain.CartDetail;
import com.example.food_store.domain.Product;
import com.example.food_store.domain.User;
import com.example.food_store.repository.CartDetailRepository;
import com.example.food_store.repository.CartRepository;
import com.example.food_store.service.ProductService;
import com.example.food_store.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {
    private final ProductService productService;
    private final UserService userService;
    private final CartDetailRepository cartDetailRepository;
    private final CartRepository cartRepository;

    public ItemController(ProductService productService, UserService userService,
            CartDetailRepository cartDetailRepository, CartRepository cartRepository) {
        this.productService = productService;
        this.userService = userService;
        this.cartDetailRepository = cartDetailRepository;
        this.cartRepository = cartRepository;
    }

    @GetMapping("/product/{id}")
    public String getProductPage(Model model, @PathVariable long id) {
        Product prd = this.productService.fetchProductById(id).get();
        model.addAttribute("prd", prd);
        return "client/product/detail";
    }

    @PostMapping("/add-product-to-cart/{id}")
    public String addProductToCart(@PathVariable long id, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        long productId = id;
        String email = (String) session.getAttribute("email");
        this.productService.handleAddProductToCart(email, productId, session);
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String getCartPage(Model model, HttpServletRequest request) {
        User currentUser = new User();
        HttpSession session = request.getSession(false);
        long id = (long) session.getAttribute("id");
        currentUser.setId(id);
        Cart cart = this.productService.fetchByUser(currentUser);
        if (cart == null)
            return "client/cart/show";
        List<CartDetail> cartDetails = cart.getCartDetails();

        double totalPrice = 0;
        for (CartDetail cartDetail : cartDetails)
            totalPrice += cartDetail.getPrice() * cartDetail.getQuantity();

        model.addAttribute("cartDetails", cartDetails);
        model.addAttribute("totalPrice", totalPrice);
        return "client/cart/show";
    }

}
