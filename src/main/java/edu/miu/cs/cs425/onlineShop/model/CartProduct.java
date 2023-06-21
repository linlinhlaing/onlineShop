package edu.miu.cs.cs425.onlineShop.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class CartProduct {
    @Id
    @GeneratedValue
    @Column(name = "cartProductId")
    private Long id;
    private int quantity;
    private double totalPrice;
    @OneToOne(cascade = CascadeType.ALL)
    private Product product;
    public CartProduct(int quantity,double totalPrice) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}
