package com.example.springboot.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.springboot.dtos.ProductRecordDto;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import jakarta.validation.Valid;


@RestController
public class ProductController {
    
    @Autowired
    ProductRepository productRepository;

    @PostMapping( "/products")
    
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto){
        var ProductModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, ProductModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(ProductModel));
    }
}
