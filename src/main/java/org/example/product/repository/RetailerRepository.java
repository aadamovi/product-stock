package org.example.product.repository;

import org.example.product.domain.Product;
import org.example.product.domain.Retailer;
import org.springframework.stereotype.Repository;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

import static org.example.product.domain.ProductRules.IS_BLOCKED;
import static org.example.product.domain.ProductRules.IS_MINIMUM_STOCK;

@Repository
public class RetailerRepository {
    private static final String TEST_SHOP_NAME = "testShop";
    private static final String DEV_SHOP_NAME = "devShop";
    private final Map<String, Retailer> retailerStorage;

    public RetailerRepository() {
        Retailer testShop = new Retailer(TEST_SHOP_NAME, Set.of(
            new Product("shoes", 8, 4, false, Set.of(IS_MINIMUM_STOCK, IS_BLOCKED)),
            new Product("t-shirt", 7, 5, false, Set.of(IS_MINIMUM_STOCK, IS_BLOCKED))
        ));

        Retailer devShop = new Retailer(DEV_SHOP_NAME, Set.of(
            new Product("pc", 5, 0, true, Set.of(IS_MINIMUM_STOCK, IS_BLOCKED)),
            new Product("mac", 7, 5, false, Set.of(IS_MINIMUM_STOCK, IS_BLOCKED)),
            new Product("linux", 7, 5, false, Set.of(IS_MINIMUM_STOCK, IS_BLOCKED))
        ));

        this.retailerStorage = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(TEST_SHOP_NAME, testShop),
            new AbstractMap.SimpleEntry<>(DEV_SHOP_NAME, devShop));
    }

    public Product findProductByRetailerAndName(String retailer, String name) {
        return retailerStorage.get(retailer).getProducts().stream()
            .filter(product -> product.getName().equals(name))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("No product with specified name found"));
    }
}
