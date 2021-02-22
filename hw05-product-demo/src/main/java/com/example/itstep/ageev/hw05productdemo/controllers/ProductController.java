package com.example.itstep.ageev.hw05productdemo.controllers;

import com.example.itstep.ageev.hw05productdemo.domain.Product;
import com.example.itstep.ageev.hw05productdemo.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("products", productService.getAll());
        return "products";
    }

    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.getOne(id));
        return "update";
    }

    @PostMapping("/update")
    public String updateProductPost(@ModelAttribute("product") Product product) {
        productService.updateProduct(product);
        return "redirect:products";
    }

    @GetMapping("/addProduct")
    public String addProduct() {
        return "create";
    }

    @PostMapping("/addProduct")
    public String creteProduct(@ModelAttribute("product") Product product) {
        productService.createProduct(product);
        return "redirect:products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
