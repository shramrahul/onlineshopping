package com.shram.onlineshopping.controller;

import com.shram.onlineshopping.domain.Category;
import com.shram.onlineshopping.domain.Product;
import com.shram.onlineshopping.exception.ProductNotFoundException;
import com.shram.onlineshopping.service.CategoryService;
import com.shram.onlineshopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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




    public void populateDatabase(){
        if(categoryService.getAllCategories().isEmpty())categoryService.insertCategories();
         if (productService.getAllProducts().isEmpty()) productService.insertProductsInDatabase();
    }
}
