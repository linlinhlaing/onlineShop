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
@Table(name = "orderlines")
public class OrderLine {
    @Id
    @GeneratedValue
    @Column(name = "orderLineId")
    private Long id;
    private int quantity;
    private double totalPrice;
    @OneToMany
    private List<Product> productList;


    public OrderLine(int quantity, double totalPrice) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}
