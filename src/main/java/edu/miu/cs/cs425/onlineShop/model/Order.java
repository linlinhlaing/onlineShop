package edu.miu.cs.cs425.onlineShop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "orderId")
    private Long id;
    private String invoiceNo;
    private String status;
    private LocalDate date;
    private double totalPrice;
    private String paymentMethod;
    @OneToMany
    private List<OrderLine> orderLineList;

    public Order(String invoiceNo, String status, LocalDate date, double totalPrice, String paymentMethod) {
        this.invoiceNo = invoiceNo;
        this.status = status;
        this.date = date;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
    }


}
