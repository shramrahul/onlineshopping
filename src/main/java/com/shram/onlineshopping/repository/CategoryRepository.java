package com.shram.onlineshopping.repository;
import com.shram.onlineshopping.domain.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer> {

    @Query("SELECT c FROM Category c where c.active =:active")
    List<Category> findAllActiveCategories(@Param("active") boolean active);
}
