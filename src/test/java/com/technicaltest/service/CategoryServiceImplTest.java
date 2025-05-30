package com.technicaltest.service;

import com.technicaltest.dto.CategoriesDTO;
import com.technicaltest.mappers.CategoryMapper;
import com.technicaltest.model.Categories;
import com.technicaltest.repository.CategoryRepository;
import com.technicaltest.service.implementation.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {
    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private CategoryMapper categoryMapper;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private CategoriesDTO categoriesDTO;
    private Categories categories;

    @BeforeEach
    void setUp() {
        categoriesDTO = new CategoriesDTO();
        categoriesDTO.setCategoryName("Test");
        categories = new Categories();
        categories.setCategoryName("Test");
    }

    @Test
    void save_ShouldThrowException_WhenCategoryIsNull() {
        assertThrows(RuntimeException.class, () -> categoryService.save(null));
    }

    @Test
    void save_ShouldThrowException_WhenCategoryHasId() {
        categoriesDTO.setCategoryID(1);
        assertThrows(RuntimeException.class, () -> categoryService.save(categoriesDTO));
    }

    @Test
    void findAll_ShouldReturnList() {
        when(categoryRepository.findAll()).thenReturn(List.of(categories));
        when(categoryMapper.listEntitytoCategoryDTO(anyList())).thenReturn(List.of(categoriesDTO));

        List<CategoriesDTO> result = categoryService.findAll();

        assertEquals(1, result.size());
        assertEquals("Test", result.get(0).getCategoryName());
    }

    @Test
    void findById_ShouldReturnCategory() throws Exception {
        when(categoryRepository.findById(1)).thenReturn(Optional.of(categories));
        when(categoryMapper.EntitytoCategoryDTO(categories)).thenReturn(categoriesDTO);

        CategoriesDTO result = categoryService.findById(1);

        assertNotNull(result);
        assertEquals("Test", result.getCategoryName());
    }

    @Test
    void findById_ShouldThrowException_WhenNotFound() {
        when(categoryRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(Exception.class, () -> categoryService.findById(1));
    }
}
