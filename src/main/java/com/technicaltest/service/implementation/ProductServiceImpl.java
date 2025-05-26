package com.technicaltest.service.implementation;

import com.technicaltest.dto.ProductDTO;
import com.technicaltest.mappers.ProductMapper;
import com.technicaltest.model.Categories;
import com.technicaltest.model.Products;
import com.technicaltest.model.Suppliers;
import com.technicaltest.repository.ProductRepository;
import com.technicaltest.service.IProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public void saveRamdom() {
        List<Suppliers> list = new ArrayList<>();
        List<Categories>listCategory = new ArrayList<>();

        List<ProductDTO> products = List.of(
                new ProductDTO(1, "Description 1", list, listCategory,2, 2000000, 50,3,2,Boolean.FALSE)
        );


        productRepository.saveAll(productRepository.saveAll( productMapper.listDTOToListEntity(products)));
    }

    @Override
    public void save(ProductDTO Product) {

    }

    @Override
    public List<ProductDTO> findPage(Pageable pageable) {
        return productMapper.listEntitytoProductDTO(productRepository.findAll());
    }

    @Override
    public List<ProductDTO> findAll() {
        //return List.of();
        List<Products> productos =  productRepository.findAll();
        return productMapper.listEntitytoProductDTO(productos);
    }

    @Override
    public ProductDTO findById(Integer id) throws Exception {
       return productMapper.EntitytoProductDTO(productRepository.findById(id).orElseThrow(() -> new Exception()));
    }
}
