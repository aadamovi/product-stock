package org.example.product.controller;

import org.example.product.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final StockService productStockService;

    @Autowired
    public ProductController(StockService productStockService) {
        this.productStockService = productStockService;
    }

    @GetMapping(("/stock"))
    @ResponseBody
    public Integer filterBySingleCriteria(@RequestParam String retailer, @RequestParam String product) {
        return productStockService.getProductCurrentStock(retailer, product);
    }
}
