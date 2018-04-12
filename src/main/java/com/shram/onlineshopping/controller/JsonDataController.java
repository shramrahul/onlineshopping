package com.shram.onlineshopping.controller;

import com.shram.onlineshopping.domain.Product;
import com.shram.onlineshopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/json/data")
public class JsonDataController {

    @Autowired
    ProductService productService;

    @RequestMapping(value="/all/products",method = RequestMethod.GET)

    public @ResponseBody String getAllProducts(){
        System.out.println("here we go----------------"+productService.getActiveProducts());
        return productService.getActiveProducts().toString();
    }


    @RequestMapping(value="/category/{id}/products",method = RequestMethod.GET)
    public @ResponseBody List<Product> getAllProductsInCategory(@PathVariable("id") int id){
        return productService.getActiveProductsByCategory(id);
    }

}
