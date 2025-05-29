package com.technicaltest.service;

import com.technicaltest.dto.ProductDTO;
import com.technicaltest.util.PagedResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IProductService {
    void saveRamdom();
    void save(ProductDTO product);
    PagedResponse findPage(Pageable pageable);
    List<ProductDTO> findAll();
    ProductDTO findById(Integer id) throws Exception;
}
