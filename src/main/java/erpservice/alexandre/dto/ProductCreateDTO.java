package erpservice.alexandre.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCreateDTO {
    // CreateDTO é os campos do Body
    private String productName;
    private String productDescription;
    private double productPrice;
    private int productStock;
    private int quantity;
    // private LocalDateTime createdAt;
    // private LocalDateTime updatedAt;

}
