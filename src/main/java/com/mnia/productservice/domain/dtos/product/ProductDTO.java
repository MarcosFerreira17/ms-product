package com.mnia.productservice.domain.dtos.product;

import com.mnia.productservice.domain.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
public class ProductDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean status;

    public ProductDTO(Product product){
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        status = product.getStatus();
    }
}
