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
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Long id;
    private String name;
    private double price;
    private String description;
    private String image;
    @OneToMany
    private List<Review> reviewList;

    public Product(String name, double price, String description, String image) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }


}
