package com.shram.onlineshopping.controller;

import com.shram.onlineshopping.domain.Product;
import com.shram.onlineshopping.service.CategoryService;
import com.shram.onlineshopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/manage")
public class ManagementController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @RequestMapping(value="/products", method = RequestMethod.GET)
    public String showManagedProducts(@ModelAttribute Product product, Model model){
//        ModelAndView mv= new ModelAndView("page");
        model.addAttribute("categories",categoryService.getAllActiveCategories());
        model.addAttribute("userClickedManageProducts",true);
        model.addAttribute("title","Manage Products");
        model.addAttribute("product",new Product());
//        mv.addObject("product",new Product());
        return "page";
    }

    @RequestMapping(value="/products", method = RequestMethod.POST)
    public ModelAndView processProduct(@ModelAttribute Product product){
        ModelAndView mv= new ModelAndView("page");
        productService.add(product);
        return mv;
    }
}
