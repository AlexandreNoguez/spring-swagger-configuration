package erpservice.alexandre.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import erpservice.alexandre.entities.CustomerEntity;
import erpservice.alexandre.entities.pk.PurchaseCustomer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    private Long idCustomer;
    private String customerName;
    private String customerEmail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Set<PurchaseCustomer> purchaseCustomers;

    public CustomerDTO(CustomerEntity custonerEntity) {
        BeanUtils.copyProperties(custonerEntity, this);
    }

    public static List<CustomerDTO> convertList(List<CustomerEntity> customerEntities) {
        List<CustomerDTO> customerDTOs = new ArrayList<>();
        for (CustomerEntity customerEntity : customerEntities) {
            customerDTOs.add(new CustomerDTO(customerEntity));
        }
        return customerDTOs;
    }
}
