package com.example.itstep.ageev.hw05productdemo.services;

import com.example.itstep.ageev.hw05productdemo.domain.Product;
import java.util.List;

public interface ProductService {
    Iterable<Product> getAll();
    Product getOne(Long id);
    void deleteProduct(Long id);
    Product createProduct(Product product);
    Product updateProduct(Product product);
}
