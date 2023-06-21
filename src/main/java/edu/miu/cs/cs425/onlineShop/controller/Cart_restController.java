package edu.miu.cs.cs425.onlineShop.controller;

import edu.miu.cs.cs425.onlineShop.model.Cart;
import edu.miu.cs.cs425.onlineShop.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
public class Cart_restController {
    @GetMapping(value = "cart/count")
    public ResponseEntity<?> getCartCount(Customer customer){
         Long count = customer.getCart().getCartProductList().stream().count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
