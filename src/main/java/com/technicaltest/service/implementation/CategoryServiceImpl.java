package com.technicaltest.service.implementation;

import com.technicaltest.dto.CategoriesDTO;
import com.technicaltest.mappers.CategoryMapper;
import com.technicaltest.model.Categories;
import com.technicaltest.repository.CategoryRepository;
import com.technicaltest.service.ICategoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;

        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoriesDTO save(CategoriesDTO category) {
         if (category == null || category.getCategoryID() != null) {
             throw new RuntimeException("La categoría es nula o ya tiene un ID asignado.");
         }
       Categories categorySave = CategoryMapper.INSTANCE.DtoToEntity(category);
       Optional<Categories> categorySaved = Optional.of(categoryRepository.save(categorySave));
       return categoryMapper.EntitytoCategoryDTO(categorySaved.get());
       //return categoryMapper.EntitytoCategoryDTO();
    }

    @Override
    public List<CategoriesDTO> findPage(Pageable pageable) {
        return List.of();
    }

    @Override
    public List<CategoriesDTO> findAll() {

        return categoryMapper.listEntitytoCategoryDTO(categoryRepository.findAll());

    }

    @Override
    public CategoriesDTO findById(Integer id) throws Exception {
        return categoryRepository.findById(id)
                .map(categoryMapper::EntitytoCategoryDTO)
                .orElseThrow(() -> new Exception());
    }
}
