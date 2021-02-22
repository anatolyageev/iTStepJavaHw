package com.example.itstep.ageev.hw05productdemo.services;

import com.example.itstep.ageev.hw05productdemo.domain.Product;

public interface ProductService {
    Iterable<Product> getAll();

    Product getOne(Long id);

    Product getOneByLabel(String label);

    void deleteProduct(Long id);

    Product createProduct(Product product);

    Product updateProduct(Product product);
}
