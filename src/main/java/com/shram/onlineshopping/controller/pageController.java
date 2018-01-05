package com.shram.onlineshopping.controller;

import com.shram.onlineshopping.domain.Category;
import com.shram.onlineshopping.service.CategoryService;
import com.shram.onlineshopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class pageController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @RequestMapping(value={"/","/home","/index"})
    public ModelAndView index(){
        populateDatabase();
        ModelAndView mv= new ModelAndView("page");
        mv.addObject("title","Home");
        mv.addObject("userClickHome",true);
        mv.addObject("categories",categoryService.getAllActiveCategories());
        return mv;
    }

    @RequestMapping(value={"/about"})
    public ModelAndView about(){
        ModelAndView mv= new ModelAndView("page");
        mv.addObject("title","About");
        mv.addObject("userClickAbout",true);
        return mv;
    }

    @RequestMapping(value={"/contact"})
    public ModelAndView contact(){
        ModelAndView mv= new ModelAndView("page");
        mv.addObject("title","Contact");
        mv.addObject("userClickContact",true);
        return mv;
    }


    /*
    * method to show all the products in a category
    * */

    @RequestMapping(value="show/all/products")
    public ModelAndView showAllProducts(){
        ModelAndView mv= new ModelAndView("page");
        mv.addObject("title","All Products");
        mv.addObject("userClickAllProducts",true);
        mv.addObject("categories",categoryService.getAllActiveCategories());
        return mv;
    }

    @RequestMapping(value="show/category/{id}/products")
    public ModelAndView showAllProductsInACategory(@PathVariable("id") int id){
        ModelAndView mv= new ModelAndView("page");
        mv.addObject("category",categoryService.getCategoryById(id));
        mv.addObject("userClickCategoryProducts",true);
        mv.addObject("title",categoryService.getCategoryById(id).getName());
       // mv.addObject("products",categoryService.getAllProductsInACategory(id));
        mv.addObject("categories",categoryService.getAllActiveCategories());
        return mv;
    }

    public void populateDatabase(){
        if(categoryService.getAllCategories().isEmpty())categoryService.insertCategories();
         if (productService.getAllProducts().isEmpty()) productService.insertProductsInDatabase();
    }
}
