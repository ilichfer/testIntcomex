package com.technicaltest.service;

import com.technicaltest.dto.CategoriesDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ICategoryService {
    void save(CategoriesDTO categories);
    List<CategoriesDTO> findPage(Pageable pageable);
    List<CategoriesDTO> findAll();
    CategoriesDTO findById(Integer id) throws Exception;
}
