package com.jtsolv.jtsolvcurr.gamedices.service.admin;

import com.jtsolv.jtsolvcurr.gamedices.exception.ResourceNotFoundException;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.Product;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
