package com.emart.productService.repository;

import com.emart.productService.model.ProductInfo;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveCassandraRepository<ProductInfo, Integer> {

    Flux<ProductInfo> findByproductId(Integer productId);
}
