package edu.miu.cs.cs425.onlineShop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue
    @Column(name = "cartId")
    private Long id;
    private double totalPrice;
    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private List<CartProduct> cartProductList;

    public Cart(double totalPrice) {
        this.totalPrice = totalPrice;
    }


}
