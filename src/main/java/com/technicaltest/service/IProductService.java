package com.technicaltest.service;

import com.technicaltest.dto.ProductDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IProductService {
    void saveRamdom();
    void save(ProductDTO product);
    List<ProductDTO> findPage(Pageable pageable);
    List<ProductDTO> findAll();
    ProductDTO findById(Integer id) throws Exception;
}
