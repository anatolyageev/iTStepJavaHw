package org.example.ageev.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.example.ageev.domain.Product;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt("id"));
        product.setLabel(resultSet.getString("label"));
        product.setPrice(resultSet.getDouble("price"));
        return product;
    }
}
