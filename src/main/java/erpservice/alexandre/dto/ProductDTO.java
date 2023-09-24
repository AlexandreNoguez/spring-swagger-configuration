package erpservice.alexandre.dto;

import java.util.List;

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

    public ProductDTO(ProductEntity productEntity) {
        BeanUtils.copyProperties(productEntity, this);
    }

    public ProductDTO(List<ProductEntity> productEntities) {
    }

}
