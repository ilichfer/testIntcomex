package com.technicaltest.controller;

import com.technicaltest.dto.CategoriesDTO;
import com.technicaltest.service.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Tag(name = "Category", description = "Category management API")
@RestController
@RequestMapping("/Category")
public class CategoryController {
    
    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

   // @Operation(summary = "Create a new category", description = "Saves a new category in the system")
    @PostMapping("/save")
    public ResponseEntity<CategoriesDTO> createCategories(@RequestBody CategoriesDTO category) {
        categoryService.save(category);
        return ResponseEntity.ok(category);
    }

    //@Operation(summary = "Get paginated categories", description = "Retrieves a paginated list of categories")
    @GetMapping("/findAll")
    public ResponseEntity<List<CategoriesDTO>> getProducts() {


        return ResponseEntity.ok(categoryService.findAll());
    }

   // @Operation(summary = "Get category by ID", description = "Retrieves a category by its ID")
    @GetMapping("/{id}")
    public ResponseEntity<CategoriesDTO> getCategoryById(@PathVariable Integer id) throws Exception {

        return ResponseEntity.ok(categoryService.findById(id));
    }
}
