package org.luvom.mockmicroservices.service;

import org.luvom.mockmicroservices.exception.ResourceNotFoundException;
import org.luvom.mockmicroservices.model.Product;
import org.luvom.mockmicroservices.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    public Product save(Product product) {
        if(product.getProductId() == null) {
            product.setProductId(UUID.randomUUID().toString());
        }
        return productRepository.save(product);
    }

    public Product update(String id, Product product) {
        Product existingProduct = findById(id);
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setStock(product.getStock());
        existingProduct.setActive(product.getActive());
        return productRepository.save(existingProduct);
    }

    public void delete(String id) {
        Product product = findById(id);
        productRepository.delete(product);
    }

    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Product deactivateProduct(String id) {
        Product product = findById(id);
        product.setActive(false);
        return productRepository.save(product);
    }
}
