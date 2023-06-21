package edu.miu.cs.cs425.onlineShop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue
    @Column(name = "reviewId")
    private Long id;
    private String name;
    private String description;
    private String rating;
    private LocalDate date;


    public Review(String name, String description, String rating, LocalDate date) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.date = date;
    }


}
