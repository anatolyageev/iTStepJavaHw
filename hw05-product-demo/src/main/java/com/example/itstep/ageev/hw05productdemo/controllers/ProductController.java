package com.example.itstep.ageev.hw05productdemo.controllers;

import com.example.itstep.ageev.hw05productdemo.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String homePage(){
        return "index";
    }

    @GetMapping("/products")
    public String products(Model model){
        model.addAttribute("products",productService.getAll());
        return "products";
    }
}
