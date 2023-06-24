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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    private Long id;
    @NotBlank(message = "Street is required")
    private String street;
    @NotBlank(message = "City is required")
    private String city;
    @NotBlank(message = "State is required")
    private String state;
    @NotBlank(message = "ZipCode is required")
    private String zipCode;

    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

}