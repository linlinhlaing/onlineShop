package edu.miu.cs.cs425.onlineShop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "street is required")
    private String street;
    @NotBlank(message = "city is required")
    private String city;
    @NotBlank(message = "state is required")
    private String state;
    @NotBlank(message = "zipCode is required")
    private String zipCode;

    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

}