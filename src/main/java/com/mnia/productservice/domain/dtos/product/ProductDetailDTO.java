package com.mnia.productservice.domain.dtos.product;

import com.mnia.productservice.domain.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDetailDTO {
    private String name;
    private String description;
    private BigDecimal price;

    public ProductDetailDTO(Product product){
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
    }
}