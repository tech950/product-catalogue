package com.product.catalogue.model;

import com.product.catalogue.db.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
@Service
public interface ProductMapper {

    Product productDtoToProduct(ProductDto product);

    ProductDto productToProductDto(Product product);
}
