package _quiz.quiz.services;
import _quiz.quiz.entity.ProductEntity;
import _quiz.quiz.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity createProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    public ProductEntity updateProduct(Long id, ProductEntity productDetails) {
        ProductEntity product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setCategory(productDetails.getCategory());
        return productRepository.save(product);
}
}
