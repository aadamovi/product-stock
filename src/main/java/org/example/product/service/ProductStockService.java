package org.example.product.service;

import org.example.product.repository.RetailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductStockService implements StockService {

    private final RetailerRepository retailerRepository;

    @Autowired
    public ProductStockService(RetailerRepository retailerRepository) {
        this.retailerRepository = retailerRepository;
    }

    @Override
    public int getProductCurrentStock(String retailer, String product) {
        return retailerRepository.findProductByRetailerAndName(retailer, product).getStock();
    }
}
