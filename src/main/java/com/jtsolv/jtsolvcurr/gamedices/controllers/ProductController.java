package com.jtsolv.jtsolvcurr.gamedices.controllers;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.Product;
import com.jtsolv.jtsolvcurr.gamedices.service.admin.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = { "", "/" })
    public Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }
}
