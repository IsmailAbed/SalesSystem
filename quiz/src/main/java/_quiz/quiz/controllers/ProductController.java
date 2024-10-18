package _quiz.quiz.controllers;

import _quiz.quiz.entity.ProductEntity;
import _quiz.quiz.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products") // Adding base path for product-related operations
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ProductEntity createProduct(@RequestBody ProductEntity product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long id, @RequestBody ProductEntity productDetails) {
        ProductEntity updatedProduct = productService.updateProduct(id, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }
}
