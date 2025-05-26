package com.technicaltest.controller;


import com.technicaltest.dto.ProductDTO;
import com.technicaltest.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }



    @PostMapping("/create")
    public ResponseEntity<String> createProducts() {

        productService.saveRamdom();
        return ResponseEntity.ok("100,000 productos creados exitosamente");
    }

/*
    @GetMapping("/findAll")
    public Page<ProductDTO> getProducts(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "50") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return productService.findAll(pageable);
    }
    */

    @GetMapping("/findAll")
    public ResponseEntity<List<ProductDTO>> getProducts() {


        return ResponseEntity.ok(productService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id) throws Exception {

       return ResponseEntity.ok(productService.findById(id));
    }




}
