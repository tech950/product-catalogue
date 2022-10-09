package com.product.catalogue.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Entity
@Table(name = "PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @NotNull
    @Id
    String id;
    String name;
    String description;
}
