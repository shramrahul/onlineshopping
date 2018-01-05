package com.shram.onlineshopping.test;

import com.shram.onlineshopping.domain.Category;
import com.shram.onlineshopping.service.CategoryService;
import com.shram.onlineshopping.service.serviceimpl.CategoryServiceImpl;
import org.junit.Assert;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.Assert.*;

public class CategoryTest {

    private static AnnotationConfigApplicationContext context;
    private static CategoryService categoryService;
    private Category category;

    @BeforeClass
    public static void init(){
        context=new AnnotationConfigApplicationContext();
        context.scan("com.shram.onlineshopping");
        context.refresh();
    categoryService= new CategoryServiceImpl();
    }


    @Test
    public void testGetCategoryByid(){
        category=categoryService.getCategoryById(1);
        Assert.assertEquals("Phone",category.getName());
    }
}
