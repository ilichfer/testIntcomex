package com.technicaltest.service;

import com.technicaltest.dto.ProductDTO;
import com.technicaltest.mappers.ProductMapper;
import com.technicaltest.model.Categories;
import com.technicaltest.model.Products;
import com.technicaltest.model.Suppliers;
import com.technicaltest.repository.CategoriesRepository;
import com.technicaltest.repository.ProductRepository;
import com.technicaltest.repository.SupplierRepository;
import com.technicaltest.service.implementation.ProductServiceImpl;
import com.technicaltest.util.PagedResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private SupplierRepository supplierRepository;
    @Mock
    private CategoriesRepository categoriesRepository;
    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductServiceImpl productService;

    private Products product;
    private ProductDTO productDTO;
    private Suppliers supplier;
    private Categories category;

    @BeforeEach
    void setUp() {
        supplier = new Suppliers();
        category = new Categories();
        product = new Products(1, "Laptop", supplier, category, 10, 10000, 10, 1, 1, false);
        productDTO = new ProductDTO();
        productDTO.setProductID(1);
        productDTO.setProductName("Laptop");
    }

    @Test
    void findAll_ShouldReturnList() {
        when(productRepository.findAll()).thenReturn(List.of(product));
        when(productMapper.listEntitytoProductDTO(anyList())).thenReturn(List.of(productDTO));

        List<ProductDTO> result = productService.findAll();

        assertEquals(1, result.size());
        assertEquals("Laptop", result.get(0).getProductName());
    }

    @Test
    void findById_ShouldReturnProduct() throws Exception {
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        when(productMapper.EntitytoProductDTO(product)).thenReturn(productDTO);

        ProductDTO result = productService.findById(1);

        assertNotNull(result);
        assertEquals(1, result.getProductID());
    }

    @Test
    void findById_ShouldThrowException_WhenNotFound() {
        when(productRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(Exception.class, () -> productService.findById(1));
    }

    @Test
    void findPage_ShouldReturnPagedResponse() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Products> page = new PageImpl<>(List.of(product), pageable, 1);
        when(productRepository.findAll(pageable)).thenReturn(page);

        PagedResponse response = productService.findPage(pageable);

        assertNotNull(response);
        assertEquals(1, response.getTotalElements());
    }
}
