package com.carx.demo.repo;

import com.carx.demo.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    @Query("select c from Category c where c.id= :id")
    Category findCategoryById(@Param("id") Long id);

}
