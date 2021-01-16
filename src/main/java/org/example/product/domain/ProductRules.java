package org.example.product.domain;

import java.util.function.Predicate;

public enum ProductRules implements Predicate<Product> {
    IS_MINIMUM_STOCK(product -> product.getStock() == product.getMinimalStock()),
    IS_BLOCKED(Product::isBlocked),
    IS_ONE_OFF(Product::isOneOff);

    private final Predicate<Product> predicate;

    ProductRules(Predicate<Product> predicate) {
        this.predicate = predicate;
    }

    public Predicate<Product> getPredicate() {
        return predicate;
    }

    @Override
    public boolean test(Product product) {
        return predicate.test(product);
    }

    @Override
    public Predicate<Product> and(Predicate<? super Product> other) {
        return predicate.and(other);
    }

    @Override
    public Predicate<Product> negate() {
        return predicate.negate();
    }

    @Override
    public Predicate<Product> or(Predicate<? super Product> other) {
        return predicate.or(other);
    }
}
