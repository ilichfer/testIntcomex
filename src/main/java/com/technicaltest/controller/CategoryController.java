package com.technicaltest.controller;

import com.technicaltest.dto.CategoriesDTO;
import com.technicaltest.service.ICategoryService;
import com.technicaltest.util.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Category")
@Tag(name = "Category", description = "Category management API")
public class CategoryController {
    
    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "Create a new category", description = "Saves a new category in the system")
    @PostMapping()
    public ResponseEntity<ApiResponse> createCategories(@RequestBody CategoriesDTO category) {
        CategoriesDTO categoryResponse;
        ApiResponse<String> response;
        try {
             categoryResponse = categoryService.save(category);
        } catch (RuntimeException e) {
            response = new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), "Error al crear la categoría", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
        response = new ApiResponse<>(HttpStatus.OK.value(), "creacion exitosa",categoryResponse.toString());
        return ResponseEntity.ok(response);
    }


}
