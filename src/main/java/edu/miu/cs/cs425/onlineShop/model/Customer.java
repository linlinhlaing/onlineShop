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
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "customerId")
    private Long id;
    private String name;
    private String email;
    private String password;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;
    @OneToMany
    private List<Order> orderList;

    public Customer(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
