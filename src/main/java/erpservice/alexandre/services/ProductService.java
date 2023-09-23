package erpservice.alexandre.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import erpservice.alexandre.entities.ProductEntity;
import erpservice.alexandre.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    // @Value("${api.baseurl}")
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<ProductEntity> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    public ProductEntity createProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    public Optional<ProductEntity> updateProduct(Long productId, ProductEntity updatedProduct) {
        if (!productRepository.existsById(productId)) {
            return Optional.empty(); // Produto não encontrado
        }
        updatedProduct.setIdProduct(productId);
        return Optional.of(productRepository.save(updatedProduct));
    }

    public boolean deleteProduct(Long productId) {
        if (!productRepository.existsById(productId)) {
            return false; // Produto não encontrado
        }
        productRepository.deleteById(productId);
        return true;
    }

}
