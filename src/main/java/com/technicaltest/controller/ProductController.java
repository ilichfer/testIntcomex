package com.technicaltest.controller;


import com.technicaltest.dto.CategoriesDTO;
import com.technicaltest.dto.ProductDTO;
import com.technicaltest.service.IProductService;
import com.technicaltest.util.ApiResponse;
import com.technicaltest.util.PagedResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@Tag(name = "Product", description = "Product management API")
public class ProductController {

    private final IProductService productService;
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Create a new product", description = "Saves a new product in the system")
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

    @Operation(summary = "search products by page ", description = "search products by page in the system")
    @GetMapping("/products")
    public ResponseEntity<PagedResponse> getProducts(Pageable pageable) {
    try
        {
            return ResponseEntity.ok(productService.findPage(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @Operation(summary = "find product by id", description = "find products by id in the system")
    @GetMapping("/Products/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id) throws Exception {
       return ResponseEntity.ok(productService.findById(id));
    }
}
