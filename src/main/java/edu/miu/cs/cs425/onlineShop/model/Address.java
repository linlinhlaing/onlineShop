package edu.miu.cs.cs425.onlineShop.model;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "addresses")
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Address {
    @Id
    @GeneratedValue
    @Column(name = "addressId")
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

}