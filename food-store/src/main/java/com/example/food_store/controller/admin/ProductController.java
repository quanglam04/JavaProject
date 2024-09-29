package com.example.food_store.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.food_store.domain.Product;

import com.example.food_store.service.ProductService;
import com.example.food_store.service.UploadService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {

    private final UploadService uploadService;
    private final ProductService productService;

    public ProductController(UploadService uploadService, ProductService productService) {
        this.uploadService = uploadService;
        this.productService = productService;
    }

    @GetMapping("/admin/product")
    public String getProduct(Model model) {
        List<Product> prds = this.productService.fetchProducts();
        model.addAttribute("products", prds);
        System.out.println(prds);

        return "admin/product/show";
    }

    @GetMapping("/admin/product/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newPrd", new Product());
        return "admin/product/create";
    }

    @PostMapping("/admin/product/create")
    public String createProduct(@ModelAttribute("newPrd") @Valid Product prd,
            BindingResult newBindingResult,
            @RequestParam("productFile") MultipartFile file) {

        if (newBindingResult.hasErrors()) {
            return "admin/product/create";
        }

        String img = this.uploadService.handleSaveUploadFile(file, "product");
        prd.setImage(img);
        this.productService.createProduct(prd);
        System.out.println(prd.toString());
        return "redirect:/admin/product";

    }

}
