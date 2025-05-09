package org.luvom.mockmicroservices.controller;

import org.luvom.mockmicroservices.model.Product;
import org.luvom.mockmicroservices.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Product Controller", description = "Operations related to products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @Operation(summary = "Get all products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update existing product")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.update(id, product));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete product")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/category/{category}")
    @Operation(summary = "Get products by category")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(productService.findByCategory(category));
    }
}
