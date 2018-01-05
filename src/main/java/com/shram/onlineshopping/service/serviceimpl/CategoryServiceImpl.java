package com.shram.onlineshopping.service.serviceimpl;

import com.shram.onlineshopping.domain.Category;
import com.shram.onlineshopping.repository.CategoryRepository;
import com.shram.onlineshopping.service.CategoryService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void insertCategories() {
        addCategory(new Category(1,"Phone","phone.jpg",true));
        addCategory(new Category(2,"Television","phone.jpg",false));
        addCategory(new Category(3,"Laptop","phone.jpg",true));
        addCategory(new Category(4,"Camera","phone.jpg",true));
    }

    @Override
    public List<Category> getAllCategories() {
        return (List<Category>)categoryRepository.findAll();
    }

    @Override
    public List<Category> getAllActiveCategories() {
        return categoryRepository.findAllActiveCategories(true);
    }

    @Override
    public boolean addCategory(Category category) {
        try {
            categoryRepository.save(category);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public boolean updateCategory(Category category) {
        try {
            categoryRepository.save(category);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public boolean deleteCategory(Category category) {
        try {
            categoryRepository.delete(category);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    /*
    * getting a single category with the given id
    * */
    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.findOne( id);
    }
}
