package com.example.rediscache.service;

public interface ProductService {
    public String getProductById(Long id);

    public String updateProduct(Long id);

    public void deleteProduct(Long id);
}
