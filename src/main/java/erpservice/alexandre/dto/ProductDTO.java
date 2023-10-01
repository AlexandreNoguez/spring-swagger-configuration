package erpservice.alexandre.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;

import org.springframework.beans.BeanUtils;

import erpservice.alexandre.entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    // retorno da função
    private Long idProduct;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int productStock;
    private int quantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductDTO(ProductEntity productEntity) {
        BeanUtils.copyProperties(productEntity, this);
    }

    public ProductDTO(List<ProductEntity> productEntities) {
    }

}
