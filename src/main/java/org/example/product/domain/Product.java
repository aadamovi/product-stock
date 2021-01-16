package org.example.product.domain;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Objects;
import java.util.Set;

public class Product {
    private String name;
    private int stock;
    private int minimalStock;
    private boolean blocked;
    private Pair<Boolean, Integer> oneOffOrder;
    private Set<ProductRules> rules;

    public Product(String name, int stock, int minimalStock, boolean blocked, Set<ProductRules> rules) {
        this.name = name;
        this.stock = stock;
        this.minimalStock = minimalStock;
        this.blocked = blocked;
        this.rules = rules;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public int getMinimalStock() {
        return minimalStock;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public Set<ProductRules> getRules() {
        return rules;
    }

    public boolean isOneOff() {
        return oneOffOrder.getKey();
    }

    public Pair<Boolean, Integer> getOneOffOrder() {
        return oneOffOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return stock == product.stock &&
            minimalStock == product.minimalStock &&
            blocked == product.blocked &&
            Objects.equals(name, product.name) &&
            Objects.equals(rules, product.rules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stock, minimalStock, blocked, rules);
    }
}
