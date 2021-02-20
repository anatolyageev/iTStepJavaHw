package org.example.ageev.repository;

import java.util.List;
import org.example.ageev.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductRepository {
    private JdbcTemplate jdbcTemplate;
    private ProductMapper productMapper;

    @Autowired
    public ProductRepository(JdbcTemplate jdbcTemplate, ProductMapper productMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.productMapper = productMapper;
    }

    public Product findById(int id) {
        String FIND_BY_ID = "SELECT * FROM products WHERE id = ?";
        return jdbcTemplate.queryForObject(FIND_BY_ID, productMapper, id);
    }

    public Product findByLabel(String label) {
        String FIND_BY_LABEL = "SELECT * FROM products WHERE label = ?";
        return jdbcTemplate.queryForObject(FIND_BY_LABEL, productMapper, label);
    }

    public List<Product> findAll() {
        String FIND_ALL = "SELECT * FROM products";
        return jdbcTemplate.query(FIND_ALL, productMapper);
    }

    public int insert(Product product){
        String INSERT_PRODUCT = "INSERT INTO products(label,price) VALUES (?,?)";
        return jdbcTemplate.update(INSERT_PRODUCT, product.getLabel(),product.getPrice());
    }

    public int update(Product product){
        String UPDATE_PRODUCT = "UPDATE products SET label = ?, price = ? WHERE id = ?";
        return jdbcTemplate.update(UPDATE_PRODUCT, product.getLabel(),product.getPrice(),product.getId());
    }

    public int delete(Product product){
        String DELETE_PRODUCT = "DELETE FROM products WHERE id = ?";
        return jdbcTemplate.update(DELETE_PRODUCT,product.getId());
    }

    public void deleteAll(){
        String DELETE_ALL = "TRUNCATE TABLE products";
        jdbcTemplate.update(DELETE_ALL);
    }
}
