package com.example.madan.madanhk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class Restcontroller {

    private ProductService service;

    @Autowired
    public Restcontroller(ProductService service) {
        this.service = service;
    }

    @PostMapping("/product/add")
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        return service.postProduct(product);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }
    @GetMapping("/product/{vendor}")
    public ResponseEntity<Object> getProductsByVendor(@PathVariable String vendor) {
        return service.getSimilarVendor(vendor);
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<Object> deleteProductById(@PathVariable Long id) {
        return service.deleteProductById(id);
    }
}
