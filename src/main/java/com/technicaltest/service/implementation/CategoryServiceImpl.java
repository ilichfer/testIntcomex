package com.technicaltest.service.implementation;

import com.technicaltest.dto.CategoriesDTO;
import com.technicaltest.mappers.CategoryMapper;
import com.technicaltest.model.Categories;
import com.technicaltest.repository.CategoryRepository;
import com.technicaltest.service.ICategoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;

        this.categoryMapper = categoryMapper;
    }

    @Override
    public void save(CategoriesDTO category) {
       Categories categorySave = CategoryMapper.INSTANCE.DtoToEntity(category);
       categoryRepository.save(categorySave);


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
