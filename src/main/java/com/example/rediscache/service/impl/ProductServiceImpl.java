package com.example.rediscache.service.impl;

import com.example.rediscache.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Override
    @Cacheable(value = "products", key = "#id")
    public String getProductById(Long id) {
        System.out.println("Getting Product");
        //simulator if we get from database
        return "Product " + id;
    }

    @Override
    @CachePut(value = "products", key = "#id")
    public String updateProduct(Long id) {
        return "Updated Product " + id;
    }

    @Override
    @CacheEvict(value = "products", key = "#id")
    public void deleteProduct(Long id) {
        System.out.println("Product deleted");
    }
}
