package com.technicaltest.repository;

import com.technicaltest.model.Products;
import com.technicaltest.model.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplierRepository extends JpaRepository<Suppliers, Integer> {


}
