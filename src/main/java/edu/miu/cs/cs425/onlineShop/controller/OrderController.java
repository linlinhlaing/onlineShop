package edu.miu.cs.cs425.onlineShop.controller;

import edu.miu.cs.cs425.onlineShop.Service.*;
import edu.miu.cs.cs425.onlineShop.model.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = {"", "/product"})
@Controller
public class OrderController {
    @Autowired
    ProductService productService;
    @Autowired
    CustomerService customerService;

    @Autowired
    OrderService orderService;
    @Autowired
    AddressService addressService;
    @Autowired
    OrderLineService orderLineService;
    @Autowired
    CartService cartService;
    @Autowired
    CartProductService cartProductService;

    @PostMapping(value = "/order/payment")
    public String displayPaymentPage(@Valid @ModelAttribute("address") Address address, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getAllErrors());
            return "cart/checkout";
        }
        Customer customer = customerService.getLoginCustomer();
        customer.setAddress(address);
        addressService.saveAddress(address);
        customerService.saveCustomer(customer);
        List<CartProduct> cartProducts = customer.getCart().getCartProductList();

        List<OrderLine> orderLines = new ArrayList<>();
        double total = 0;
        for (CartProduct cartProduct : cartProducts) {
            OrderLine orderline = orderLineService.saveOrderLine(cartProduct);
            orderLines.add(orderline);
            total += cartProduct.getTotalPrice();
            cartProductService.removeByCartProductId(cartProduct.getCartProductId());
        }
        Order order = orderService.addOrderLineToOrder(total,orderLines);
        model.addAttribute("order",order);
        model.addAttribute("total",total);
        return "order/payment";
    }
}
