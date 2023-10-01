package erpservice.alexandre.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerCreateDTO {
    private String customerName;
    private String customerEmail;
    // private LocalDateTime createdAt;
    // private LocalDateTime updatedAt;

}
