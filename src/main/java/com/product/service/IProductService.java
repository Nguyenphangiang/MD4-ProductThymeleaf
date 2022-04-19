package com.product.service;

import com.product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showAll();
    void save(Product product);
    void update(int id, Product product);
    void delete(int id);
    Product findById(int id);
    Product findByName(String name);
}
