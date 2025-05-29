package com.technicaltest.controller;


import com.technicaltest.dto.CategoriesDTO;
import com.technicaltest.dto.ProductDTO;
import com.technicaltest.service.IProductService;
import com.technicaltest.util.ApiResponse;
import com.technicaltest.util.PagedResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {

    private final IProductService productService;
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/Product")
    public ResponseEntity<ApiResponse<String>> createProducts(@RequestBody CategoriesDTO category) {

        ApiResponse<String> response;
        try
        {
            productService.saveRamdom();
        } catch (Exception e) {
            response = new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), "Error al crear productos", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
        response = new ApiResponse<>(HttpStatus.OK.value(), "100,000 productos creados exitosamente", null);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/products")
    public ResponseEntity<PagedResponse> getProducts(Pageable pageable) {
    try
        {
            return ResponseEntity.ok(productService.findPage(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/Products/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id) throws Exception {
       return ResponseEntity.ok(productService.findById(id));
    }
}
