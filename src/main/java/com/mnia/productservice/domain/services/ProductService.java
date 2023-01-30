package com.mnia.productservice.domain.services;

import com.mnia.productservice.domain.dtos.product.ProductDTO;
import com.mnia.productservice.domain.dtos.product.ProductListDTO;
import com.mnia.productservice.domain.entities.Product;
import com.mnia.productservice.domain.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service @Slf4j
public class ProductService {

    private static final String REQUEST = "request all products";
    private static final String CORRELATION_ID = "correlationID";
    @Autowired
    private ProductRepository repository;

    @Transactional
    public void createProduct(ProductDTO productDTO){
        MDC.put(CORRELATION_ID, UUID.randomUUID().toString());
        log.info(REQUEST);

        Product product = Product.builder()
                        .name(productDTO.getName())
                                .description(productDTO.getDescription())
                                        .price(productDTO.getPrice())
                .status(productDTO.getStatus())
                                                        .build();
        repository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public Page<ProductDTO> getProductList(Pageable pageable){
        MDC.put(CORRELATION_ID, UUID.randomUUID().toString());
        log.info(REQUEST);
        return repository.getProductList(pageable).orElseThrow();
    }
}
