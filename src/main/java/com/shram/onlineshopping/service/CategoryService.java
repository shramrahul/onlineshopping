package com.shram.onlineshopping.service;

import com.shram.onlineshopping.domain.Category;

import java.util.List;
import java.util.Optional;


public interface CategoryService {
    void insertCategories();
    List<Category> getAllCategories();
    List<Category> getAllActiveCategories();
    boolean addCategory(Category category);
    boolean updateCategory(Category category);
    boolean deleteCategory(Category category);
    Category getCategoryById(int id);

}
