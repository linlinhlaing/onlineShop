package edu.miu.cs.cs425.onlineShop.controller;

import edu.miu.cs.cs425.onlineShop.Service.ProductService;
import edu.miu.cs.cs425.onlineShop.model.Cart;
import edu.miu.cs.cs425.onlineShop.model.CartProduct;
import edu.miu.cs.cs425.onlineShop.model.Customer;
import edu.miu.cs.cs425.onlineShop.model.Product;
import edu.miu.cs.cs425.onlineShop.repository.CartProductRepository;
import edu.miu.cs.cs425.onlineShop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = {"","/"})
@Controller
public class CartController {
    @Autowired
    ProductService productService;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CartProductRepository cartProductRepository;


//    @Autowired
//    @GetMapping(value = "/addToCart/} + ${product.id}")
//    public String displayCartQuantity() {
//        Optional<Customer> c = customerRepository.findById(1l);
//        if(c.isPresent()) {
//            Customer customer = c.get();
//            Cart mycart = customer.getCart();
//            List<CartProduct> result = mycart.getCartProductList().stream().filter(
//                    cartProduct1 -> cartProduct1.getProduct().getId() == 1
//            ).toList();
//            if (result.size() > 0) {
//                CartProduct p = result.get(0);
//                p.setQuantity(2);
//                p.setTotalPrice(100);
//                System.out.println("quantity"+p.getQuantity());
//                cartProductRepository.save(p);
//            }
//            else {
//                CartProduct p = result.get(0);
//                p.getQuantity();
//                System.out.println("quantity"+p.getQuantity());
//            }
//        }
//
//        return "cart/cart";
//    }


}
