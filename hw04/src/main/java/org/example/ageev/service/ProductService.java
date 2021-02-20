package org.example.ageev.service;

import java.util.List;
import org.example.ageev.domain.Product;
import org.example.ageev.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product findById(int id) {
       return repository.findById(id);
    }

    public Product findByLabel(String label) {
        return repository.findByLabel(label);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public int insert(Product product){
        return repository.insert(product);
    }

    public int update(Product product){
        return repository.update(product);
    }

    public int delete(Product product){
        return repository.delete(product);
    }

    public void deleteAll(){
        repository.deleteAll();
    }
}
