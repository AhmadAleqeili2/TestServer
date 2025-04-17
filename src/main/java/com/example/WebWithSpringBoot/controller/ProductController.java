package com.example.WebWithSpringBoot.controller;

import com.example.WebWithSpringBoot.model.Product;
import com.example.WebWithSpringBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    public ProductService service;
//sasdasdas
    @RequestMapping("/")
    public String Great(){
        return "Hello Ahmad";
    }
    @GetMapping("/products")
    public List<Product> GetAllProduct(){
        return service.GetAllProduct();
    }
    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id){
        return service.getProductById(id);
    }
    @PostMapping("/products")
    public ResponseEntity<?> addProduct(
            @RequestPart Product product,
            @RequestPart MultipartFile imageFile
            )
    {
        try {


            Product product1 = service.addProduct(product, imageFile);
            return new ResponseEntity<>( product1 , HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
