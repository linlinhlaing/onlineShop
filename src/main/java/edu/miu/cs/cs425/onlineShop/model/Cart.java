package edu.miu.cs.cs425.onlineShop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private double totalPrice;
//    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE},fetch = FetchType.EAGER)
@OneToMany(cascade = CascadeType.ALL)
    private List<CartProduct> cartProductList;

    public Cart(double totalPrice) {
        this.totalPrice = totalPrice;
    }


}
