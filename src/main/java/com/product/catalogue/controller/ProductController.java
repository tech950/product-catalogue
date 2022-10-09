package com.product.catalogue.controller;

import com.product.catalogue.model.ProductDto;
import com.product.catalogue.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void saveProduct(@RequestBody @Valid ProductDto productDto) {
        productService.saveProduct(productDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ProductDto getProductById(@PathVariable("id") String id) {
        return productService.getProductById(id);
    }

}
