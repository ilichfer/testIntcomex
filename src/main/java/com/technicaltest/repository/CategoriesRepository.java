package com.technicaltest.repository;

import com.technicaltest.model.Categories;
import com.technicaltest.model.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriesRepository extends JpaRepository<Categories, Integer> {


}
