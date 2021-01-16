package org.example.product.domain;

import java.util.Objects;
import java.util.Set;

public class Retailer {
    private String name;
    private Set<Product> products;

    public Retailer(String name, Set<Product> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Retailer retailer = (Retailer) o;
        return Objects.equals(name, retailer.name) &&
            Objects.equals(products, retailer.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, products);
    }
}
