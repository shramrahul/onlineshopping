package com.shram.onlineshopping.service;

import com.shram.onlineshopping.domain.Category;

import java.util.List;
import java.util.Optional;


public interface CategoryService {
    List<Category> getAllCategories();
    Optional<Category> getAllProductsInACategory(int id);
    Category getCategoryById(int id);

}
