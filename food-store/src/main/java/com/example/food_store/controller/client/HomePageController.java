package com.example.food_store.controller.client;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.food_store.domain.Order;
import com.example.food_store.domain.Product;
import com.example.food_store.domain.User;
import com.example.food_store.domain.dto.RegisterDTO;
import com.example.food_store.service.OrderService;
import com.example.food_store.service.ProductService;
import com.example.food_store.service.UserService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {

    private final ProductService productService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final OrderService orderService;

    public HomePageController(ProductService productService, UserService userService, PasswordEncoder passwordEncoder,
            OrderService orderService) {
        this.productService = productService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.orderService = orderService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<Product> products = this.productService.fetchAllProductsToHomePage();
        List<Product> productsTypeRauCu = this.productService.fetchProductByType("rau");
        productsTypeRauCu.addAll(this.productService.fetchProductByType("cu"));

        List<Product> productsTypeTraiCay = this.productService.fetchProductByType("trai-cay");
        List<Product> productsTypeThit = this.productService.fetchProductByType("thuc-pham-giau-protein");
        List<Product> productsTypeThucUong = this.productService.fetchProductByType("thuc-uong");

        model.addAttribute("products", products);
        model.addAttribute("productsTypeThucUongs", productsTypeThucUong);
        model.addAttribute("productsTypeRauCus", productsTypeRauCu);
        model.addAttribute("productsTypeTraiCays", productsTypeTraiCay);
        model.addAttribute("productsTypeThits", productsTypeThit);

        return "client/homepage/show";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerUser", new RegisterDTO());
        return "client/auth/register";
    }

    @PostMapping("/register")
    public String handleRegister(@ModelAttribute("registerUser") @Valid RegisterDTO userDTO,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "client/auth/register";
        }

        User user = this.userService.registerDTOtoUser(userDTO);

        String hashPassword = this.passwordEncoder.encode(userDTO.getPassword());

        user.setPassword(hashPassword);

        user.setRole(this.userService.getRoleByName("USER"));
        this.userService.handleSaveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "client/auth/login";
    }

    @GetMapping("/password")
    public String getForgotPasswordPage() {
        return "client/auth/password";
    }

    @GetMapping("/access-deny")
    public String getDenyPage(Model model) {
        return "client/auth/deny";
    }

    @GetMapping("/order-history")
    public String getOrderHistoryPage(Model model, HttpServletRequest request) {
        User currentUser = new User();
        HttpSession session = request.getSession(false);
        long id = (long) session.getAttribute("id");
        currentUser.setId(id);
        List<Order> orders = this.orderService.fetchOrderByUser(currentUser);

        model.addAttribute("orders", orders);
        return "client/cart/order-history";
    }

    @GetMapping("/view-profile")
    public String getProfileView(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        Long id = (Long) session.getAttribute("id");
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "client/homepage/viewProfile";
    }

}
