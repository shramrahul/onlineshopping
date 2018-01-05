package com.shram.onlineshopping.repository;

import com.shram.onlineshopping.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {


    @Query("SELECT p FROM Product p where p.active=:active")
    List<Product> findAllActiveProducts(@Param("active") boolean active);

    @Query("select p from Product p where p.categoryId=:id")
    List<Product> findAllActiveProductsInACategory(@Param("id") int categoryId);
}
