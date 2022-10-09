package com.product.catalogue.service;

import com.product.catalogue.db.ProductRepository;
import com.product.catalogue.model.ProductDto;
import com.product.catalogue.model.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public void saveProduct(ProductDto productDto) {
        productRepository.save(productMapper.productDtoToProduct(productDto));
    }

    public ProductDto getProductById(String id) {
        return productRepository.findById(id).map(productMapper::productToProductDto).orElse(null);
    }
}
