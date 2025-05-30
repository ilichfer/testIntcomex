package com.technicaltest.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.technicaltest.dto.CategoriesDTO;
import com.technicaltest.service.ICategoryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
public class categoryControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ICategoryService categoryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createCategories_ReturnsOk() throws Exception {
        CategoriesDTO dto = new CategoriesDTO();
        dto.setCategoryName("Test");
        dto.setDescription("Desc");

        Mockito.when(categoryService.save(Mockito.any())).thenReturn(dto);

        mockMvc.perform(post("/Category")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("creacion exitosa"));
    }

    @Test
    void createCategories_ReturnsBadRequest_OnException() throws Exception {
        CategoriesDTO dto = new CategoriesDTO();
        dto.setCategoryName("Test");
        dto.setDescription("Desc");

        Mockito.when(categoryService.save(Mockito.any())).thenThrow(new RuntimeException("Error"));

        mockMvc.perform(post("/Category")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Error al crear la categoría"));
    }


}
