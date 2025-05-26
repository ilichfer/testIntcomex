package com.technicaltest.repository;

import com.technicaltest.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categories, Integer> {

}
