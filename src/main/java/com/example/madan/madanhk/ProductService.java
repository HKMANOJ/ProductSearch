package com.example.madan.madanhk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ProductService {

    private Repository repo;

    @Autowired
    public ProductService(Repository repo) {
        this.repo = repo;
    }

    public ResponseEntity<Object> postProduct(Product product) {
        if (repo.existsById(product.getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product ID already exists");
        }
        Product savedProduct = repo.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
    public ResponseEntity<Object> updateProduct(Long id, Product product) {
        if (!repo.existsById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product ID not found");
        }
        Product pro=new Product();
        pro.setId(product.getId());
       pro.setCurrency(product.getCurrency());
       pro.setDescription(product.getDescription());
       pro.setName(product.getName());
       pro.setSku(product.getSku());
       pro.setVendor(product.getVendor());
       pro.setStock(product.getStock());
        Product updatedProduct = repo.save(pro);
        return ResponseEntity.ok(updatedProduct);
    }

    public ResponseEntity<Object> getSimilarVendor(String value) {
        Iterable<Product> products = repo.findByVendor(value);
        if (products.iterator().hasNext()) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No products found for vendor: " + value);
        }
    } public ResponseEntity<Object> deleteProductById(Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product ID not found");
        }
        repo.deleteById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

}
