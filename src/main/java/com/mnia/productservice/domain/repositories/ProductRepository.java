package com.mnia.productservice.domain.repositories;

import com.mnia.productservice.domain.dtos.product.ProductDTO;
import com.mnia.productservice.domain.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    @Query("{status : true}")
    Optional<Page<ProductDTO>> getProductList(Pageable pageable);
}
