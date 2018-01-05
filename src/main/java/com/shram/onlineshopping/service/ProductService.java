package com.shram.onlineshopping.service;

import com.shram.onlineshopping.domain.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductById(int id);
    public boolean add(Product product);
    public boolean update(Product product);
    public boolean delete (Product product);

    public void insertProductsInDatabase();
    public List<Product> getActiveProducts();
    public List<Product> getActiveProductsByCategory(int categoryId);
    public List<Product> getLatestActiveProducts(int count);
}
