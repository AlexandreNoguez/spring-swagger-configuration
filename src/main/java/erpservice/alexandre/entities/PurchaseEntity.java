package erpservice.alexandre.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import erpservice.alexandre.entities.pk.PurchaseCustomer;
import erpservice.alexandre.entities.pk.PurchaseProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "purchases")
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Long idPurchase;

    @Column(name = "description")
    private Long productDescription;

    @Column(name = "type")
    private Long pruchaseType;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

    @OneToMany(mappedBy = "purchaseEntity", fetch = FetchType.LAZY)
    private Set<PurchaseCustomer> purchaseCustomers;

    @OneToMany(mappedBy = "purchaseEntity", fetch = FetchType.LAZY)
    private Set<PurchaseProduct> purchaseProducts;

}