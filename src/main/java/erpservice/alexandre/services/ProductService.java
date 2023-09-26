package erpservice.alexandre.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import erpservice.alexandre.dto.ProductCreateDTO;
import erpservice.alexandre.dto.ProductDTO;
import erpservice.alexandre.entities.ProductEntity;
import erpservice.alexandre.exceptions.BusinessException;
import erpservice.alexandre.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    // private final ObjectMapper objectMapper;

    public ProductDTO createProduct(ProductCreateDTO productCreateDTO) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productCreateDTO, productEntity);
        return new ProductDTO(productRepository.save(productEntity));
    }

    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        return products.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long productId) throws BusinessException {
        return new ProductDTO(productRepository.findById(productId)
                .orElseThrow(() -> new BusinessException("Product not found")));
    }

    // public ProductDTO updateById(ProductCreateDTO productCreateDTO, Long
    // productId) throws BusinessException {
    // ProductDTO productDTO = this.getProductById(productId);
    // ProductEntity productEntity = objectMapper.convertValue(productDTO,
    // ProductEntity.class);
    // productEntity.setProductName(productDTO.getProductName());
    // productEntity.setProductDescription(productDTO.getProductDescription());
    // productEntity.setProductPrice(productDTO.getProductPrice());
    // productEntity.setProductStock(productDTO.getProductStock());

    // return productDTO;

    // }

    public ProductDTO updateProduct(Long id, ProductCreateDTO createDTO) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductEntity productEntity = optionalProduct.get();
            BeanUtils.copyProperties(createDTO, productEntity);
            ProductEntity updatedProduct = productRepository.save(productEntity);
            return new ProductDTO(updatedProduct);
        } else {
            throw new RuntimeException("Produto não encontrado");
        }
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
