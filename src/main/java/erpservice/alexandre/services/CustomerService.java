package erpservice.alexandre.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import erpservice.alexandre.dto.CustomerCreateDTO;
import erpservice.alexandre.dto.CustomerDTO;
import erpservice.alexandre.entities.CustomerEntity;
import erpservice.alexandre.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Validated
@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerDTO createCustomer(CustomerCreateDTO customerCreateDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customerCreateDTO, customerEntity);
        return new CustomerDTO(customerRepository.save(customerEntity));
    }

    @Transactional
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerEntity> customers = customerRepository.findAll();
        return CustomerDTO.convertList(customers);
    }

    public CustomerDTO getCustomerById(Long customerId) {
        Optional<CustomerEntity> customerOptional = customerRepository.findById(customerId);
        return customerOptional.map(CustomerDTO::new).orElse(null);
    }

    @Transactional
    public CustomerDTO updateCustomer(Long customerId, CustomerCreateDTO customerCreateDTO) {
        Optional<CustomerEntity> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            CustomerEntity customerEntity = customerOptional.get();
            BeanUtils.copyProperties(customerCreateDTO, customerEntity);
            CustomerEntity updatedCustomer = customerRepository.save(customerEntity);
            return new CustomerDTO(updatedCustomer);
        }
        return null;
    }

    @Transactional
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
