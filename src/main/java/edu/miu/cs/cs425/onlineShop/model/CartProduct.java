package edu.miu.cs.cs425.onlineShop.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    private Long cartProductId;
    private int quantity;
    private double totalPrice;
    @ManyToOne
    private Product product;
    public CartProduct(int quantity,double totalPrice) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}
