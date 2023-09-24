package erpservice.alexandre.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import erpservice.alexandre.entities.pk.PurchaseProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_PRODUCT")
    @SequenceGenerator(name = "SEQUENCE_PRODUCT", sequenceName = "products_product_id_seq", allocationSize = 1)
    @Column(name = "product_id")
    private Long idProduct;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String productDescription;

    @Column(name = "price")
    private double productPrice;

    @Column(name = "stock")
    private int productStock;

    @OneToMany(mappedBy = "productEntity")
    private Set<PurchaseProduct> purchaseProducts;
}
