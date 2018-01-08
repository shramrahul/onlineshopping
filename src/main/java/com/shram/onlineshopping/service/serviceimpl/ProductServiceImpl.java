package com.shram.onlineshopping.service.serviceimpl;

import com.shram.onlineshopping.domain.Product;
import com.shram.onlineshopping.repository.ProductRepository;
import com.shram.onlineshopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductServiceImpl() {
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>)productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findOne(id);
    }

    @Override
    public boolean add(Product product) {
        try {
            productRepository.save(product);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public boolean update(Product product) {
        try {
            productRepository.save(product);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public boolean delete(Product product) {
        try {
            product.setActive(false);
            productRepository.save(product);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public List<Product> getActiveProducts() {
        return productRepository.findAllActiveProducts(true);
    }

    @Override
    public List<Product> getActiveProductsByCategory(int categoryId) {
        return productRepository.findAllActiveProductsInACategory(categoryId);
    }

    @Override
    public List<Product> getLatestActiveProducts(int count) {
        return null;
    }

    public void insertProductsInDatabase(){
        add(new Product("iPhone 5s","apple","This is one of the best phone available in the market right now!","18000",5,true,1,2,0,0));
        add(new Product("Samsung s7","Samsung","This is one of the best phone available in the market right now!","17000",4,true,1,1,0,0));
        add(new Product("LG lED","LG","This is one of the best TV available in the market right now!","15000",5,true,2,2,0,0));
        add(new Product("Insperon","Dell","This is one of the best laptop available in the market right now!","30000",4,true,3,3,0,0));
        add(new Product("70D","Canon","This is one of the best DSLR available in the market right now!","35000",0,true,4,2,0,0));
    }
}
