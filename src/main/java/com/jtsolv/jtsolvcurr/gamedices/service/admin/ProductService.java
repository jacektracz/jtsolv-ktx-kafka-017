package com.jtsolv.jtsolvcurr.gamedices.service.admin;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.Product;
import org.springframework.validation.annotation.Validated;


@Validated
public interface ProductService {

    Iterable<Product> getAllProducts();

    Product getProduct( Long id);

    Product save(Product product);
}
