package com.product.catalogue.model;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@Builder
public class ProductDto {
    @NotNull
    String id;
    String name;
    String description;
}
