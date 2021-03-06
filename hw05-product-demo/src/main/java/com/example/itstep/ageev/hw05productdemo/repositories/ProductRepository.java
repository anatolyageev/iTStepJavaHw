package com.example.itstep.ageev.hw05productdemo.repositories;

import com.example.itstep.ageev.hw05productdemo.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Product getProductByLabel(String label);
}
