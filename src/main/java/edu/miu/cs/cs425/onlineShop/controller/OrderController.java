package edu.miu.cs.cs425.onlineShop.controller;

import edu.miu.cs.cs425.onlineShop.Service.AddressService;
import edu.miu.cs.cs425.onlineShop.Service.CustomerService;
import edu.miu.cs.cs425.onlineShop.Service.ProductService;
import edu.miu.cs.cs425.onlineShop.model.Address;
import edu.miu.cs.cs425.onlineShop.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = {"", "/product"})
@Controller
public class OrderController {
    @Autowired
    ProductService productService;
    @Autowired
    CustomerService customerService;

    @Autowired
    AddressService addressService;
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
        return "order/payment";
    }
}
