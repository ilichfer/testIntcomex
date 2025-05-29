package com.technicaltest.service;

import com.technicaltest.dto.CategoriesDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface ICategoryService {
    CategoriesDTO save(CategoriesDTO categories);
    List<CategoriesDTO> findPage(Pageable pageable);
    List<CategoriesDTO> findAll();
    CategoriesDTO findById(Integer id) throws Exception;
}
