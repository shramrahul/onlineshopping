package com.shram.onlineshopping.controller;

import com.shram.onlineshopping.domain.Product;
import com.shram.onlineshopping.exception.ProductNotFoundException;
import com.shram.onlineshopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;


    @RequestMapping(value="show/all/products", method= RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<Product> showAllProducts(){
        System.out.println("here---------------"+productService.getActiveProducts());
        return productService.getActiveProducts();

    }


    /*
    * view single product
    * */

    @RequestMapping(value="/show/{id}/product", method= RequestMethod.GET , produces = "application/json")
    public  Product showProductDetails(@PathVariable int id) throws ProductNotFoundException {
        Product product= productService.getProductById(id);

        if(product==null) throw new ProductNotFoundException("The Product is not available");
        //updating the view count
        product.setViews(product.getViews()+1);
        productService.update(product);
        return product;

    }



       /*
    * method to show all the products in a category
    * */

    @RequestMapping(value="show/category/{id}/products")
    public  List<Product> showAllProductsInACategory(@PathVariable("id") int id){
        return productService.getActiveProductsByCategory(id);
    }

}
