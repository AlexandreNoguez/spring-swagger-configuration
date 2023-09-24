package erpservice.alexandre.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import erpservice.alexandre.entities.pk.PurchaseCustomer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_CUSTOMER")
    @SequenceGenerator(name = "SEQUENCE_CUSTOMER", sequenceName = "customers_customer_id_seq", allocationSize = 1)
    @Column(name = "customer_id")
    private Long idCustomer;

    @Column(name = "name")
    private String customerName;

    @Column(name = "email")
    private String customerEmail;

    @OneToMany(mappedBy = "purchaseCustomers", fetch = FetchType.LAZY)
    private Set<PurchaseCustomer> purchaseCustomers;
}
