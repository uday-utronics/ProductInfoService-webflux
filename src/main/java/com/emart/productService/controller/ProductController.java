package com.emart.productService.controller;

import com.emart.productService.model.ProductInfo;
import com.emart.productService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ProductService")
public class ProductController {


    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/create")
    public Mono<ProductInfo> createProduct(@RequestBody ProductInfo productInfo){
        return productRepository.save(productInfo).onErrorResume(e -> Mono.empty());
    }

    @GetMapping("/getAll")
    public Flux<ProductInfo> getAll(){
        //return productRepository.findAll();
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            return Flux.error(new Exception("Error while fetching all products"));
        }

    }

    @GetMapping("getById/{product_id}")
    public Flux<ProductInfo> getById(@PathVariable int product_id){
        return productRepository.findByproductId(product_id).onErrorResume(e -> Flux.just(new ProductInfo()));
    }
}
