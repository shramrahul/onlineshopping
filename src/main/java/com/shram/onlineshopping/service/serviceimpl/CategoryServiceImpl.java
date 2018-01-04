package com.shram.onlineshopping.service.serviceimpl;

import com.shram.onlineshopping.domain.Category;
import com.shram.onlineshopping.repository.CategoryRepository;
import com.shram.onlineshopping.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    List<Category> list;

    CategoryRepository categoryRepository;

    public CategoryServiceImpl() {
        list= new ArrayList<>();
        list.add(new Category(1,"Phone","phone.jpg",true));
        list.add(new Category(2,"Television","phone.jpg",true));
        list.add(new Category(3,"Laptop","phone.jpg",true));
        list.add(new Category(4,"Camera","phone.jpg",true));
    }

    @Override
    public List<Category> getAllCategories() {
        return list;
    }

    @Override
    public Optional<Category> getAllProductsInACategory(int id) {
        return null;
    }

    @Override
    public Category getCategoryById(int id) {
        return list.stream().filter(c->c.getId()==id).findAny().get();
    }
}
