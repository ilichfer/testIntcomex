package com.technicaltest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.technicaltest.dto.ProductDTO;
import com.technicaltest.service.IProductService;
import com.technicaltest.util.PagedResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createProducts_ReturnsOk() throws Exception {
        Mockito.doNothing().when(productService).saveRamdom();

        mockMvc.perform(post("/Product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("100,000 productos creados exitosamente"));
    }

    @Test
    void createProducts_ReturnsBadRequest_OnException() throws Exception {
        Mockito.doThrow(new RuntimeException("Error")).when(productService).saveRamdom();

        mockMvc.perform(post("/Product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Error al crear productos"));
    }

    @Test
    void getProducts_ReturnsPagedResponse() throws Exception {
        PagedResponse pagedResponse = new PagedResponse();
        Mockito.when(productService.findPage(Mockito.any(Pageable.class))).thenReturn(pagedResponse);

        mockMvc.perform(get("/products")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isOk());
    }

    @Test
    void getProductById_ReturnsProduct() throws Exception {
        ProductDTO dto = new ProductDTO();
        dto.setProductID(1);
        Mockito.when(productService.findById(1)).thenReturn(dto);

        mockMvc.perform(get("/Products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productID").value(1));
    }

}
