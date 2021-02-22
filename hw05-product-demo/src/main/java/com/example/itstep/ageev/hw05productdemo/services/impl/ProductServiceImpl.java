package com.example.itstep.ageev.hw05productdemo.services.impl;

import com.example.itstep.ageev.hw05productdemo.domain.Product;
import com.example.itstep.ageev.hw05productdemo.exceptions.ResourceNotFoundException;
import com.example.itstep.ageev.hw05productdemo.repositories.ProductRepository;
import com.example.itstep.ageev.hw05productdemo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getOne(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot find product with id " + id));
    }

    @Override
    public Product getOneByLabel(String label) {
        return productRepository.getProductByLabel(label);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
}
