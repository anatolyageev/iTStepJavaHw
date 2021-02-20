package org.example.ageev.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Product {
    int id;
    String label;
    double price;

    public Product(String label, double price) {
        this.label = label;
        this.price = price;
    }
}
