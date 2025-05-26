package com.technicaltest.repository;

import com.technicaltest.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProductRepository extends JpaRepository<Products, Integer> {


}
