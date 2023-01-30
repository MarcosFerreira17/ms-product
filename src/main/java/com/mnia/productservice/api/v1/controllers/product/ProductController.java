package com.mnia.productservice.api.v1.controllers.product;

import com.mnia.productservice.domain.dtos.Meta;
import com.mnia.productservice.domain.dtos.product.ProductDTO;
import com.mnia.productservice.domain.dtos.product.ProductListDTO;
import com.mnia.productservice.domain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> createProduct(@RequestBody ProductDTO productDTO){
        productService.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductListDTO> getProductsList(Pageable pageable) {
        final var pageProductList = productService.getProductList(pageable);
        var meta = new Meta(
            pageProductList.getNumber() + 1,
            pageProductList.getSize(),
            pageProductList.getTotalPages(),
            pageProductList.getTotalElements()
        );

        final var productList = new ProductListDTO(
                UUID.randomUUID().toString(),
                LocalDateTime.now().toString(),
                "Products#List", meta, pageProductList.getContent());
    return ResponseEntity.ok(productList);
    }
}
