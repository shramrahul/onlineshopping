package com.shram.onlineshopping.controller;

import com.shram.onlineshopping.domain.Product;
import com.shram.onlineshopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

    @Autowired
    ProductService productService;

    @RequestMapping("/all/products")
    @ResponseBody
    public List<Product> getAllProducts(){
        return productService.getActiveProducts();
    }

    @RequestMapping("/category/{id}/products")
    @ResponseBody
    public List<Product> getAllProductsInCategory(@PathVariable("id") int id){
        return productService.getActiveProductsByCategory(id);
    }

}
