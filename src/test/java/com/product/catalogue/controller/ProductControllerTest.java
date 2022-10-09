package com.product.catalogue.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.catalogue.model.ProductDto;
import com.product.catalogue.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService productService;

    @Test
    void testSaveProduct() throws Exception {
        mockMvc.perform(post("/v1/products")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ProductDto.builder().id("1").name("prod1").build())))
                .andExpect(status().isCreated());
    }

    @Test
    void testGetProduct() throws Exception {
        when(productService.getProductById("12")).thenReturn(ProductDto.builder().id("12").name("prod1").build());

        mockMvc.perform(get("/v1/products/12"))
                .andExpectAll(status().isOk(),
                        jsonPath("$.id").value("12"),
                        jsonPath("$.name").value("prod1"),
                        jsonPath("$.description").doesNotExist()
                );

    }


}
