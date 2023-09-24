package erpservice.alexandre.entities.pk;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import erpservice.alexandre.entities.CustomerEntity;
import erpservice.alexandre.entities.PurchaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "purchase_customer")
public class PurchaseCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_PURCHASE_CUSTOMER")
    @SequenceGenerator(name = "SEQUENCE_PURCHASE_CUSTOMER", sequenceName = "purchase_customer_purchase_customer_id_seq", allocationSize = 1)

    @Column(name = "purchase_customer_id")
    private Long idPurchase;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id")
    private PurchaseEntity purchaseEntity;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity purchaseCustomers;

}
