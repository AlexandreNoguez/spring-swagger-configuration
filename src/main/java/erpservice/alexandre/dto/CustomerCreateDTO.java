package erpservice.alexandre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerCreateDTO {
    private String customerName;
    private String customerEmail;

}
