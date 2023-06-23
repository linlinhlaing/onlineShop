package edu.miu.cs.cs425.onlineShop.controller;

import edu.miu.cs.cs425.onlineShop.Service.*;
import edu.miu.cs.cs425.onlineShop.model.*;
import edu.miu.cs.cs425.onlineShop.repository.CartProductRepository;
import edu.miu.cs.cs425.onlineShop.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping(value = {"", "/product"})
@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CustomerService customerService;
    @Autowired
    CartProductService cartProductService;
    @Autowired
    CartService cartService;
    @Autowired
    AddressService addressService;


    @GetMapping(value = "/list")
    public String getProductList(Model model) {
        List<Product> products = productService.getAllProduct();
        System.out.println("hello " + products);
        model.addAttribute("products", products);
        System.out.println("hello" + products);
        return "product/list";
    }

    @PostMapping(value = "/addToCart/{productId}")
    public String displayAddToCartPage(@PathVariable("productId") Long productId, Model model) {
        Product product = productService.findById(productId);
        Customer customer = customerService.getById(1l);
        Cart cart = customer.getCart();
        System.out.println("testing" + cart);
        if (cart == null) {
            Cart newCart = new Cart(0);
            customer.setCart(newCart);

            customerService.saveCustomer(customer);
            cart = customer.getCart();
        }

        if (cart.getCartProductList() == null) {
            List<CartProduct> cartPds = new ArrayList<>();
            cart.setCartProductList(cartPds);
        }

        List<CartProduct> result = cart.getCartProductList().stream().filter(
                cartProduct1 -> cartProduct1.getProduct().getId() == productId
        ).toList();

        if (result.size() > 0) {
            CartProduct cartProduct = result.get(0);
            int totalQuantity = cartProduct.getQuantity() + 1;
            cartProduct.setQuantity(totalQuantity);

            cartProduct.setTotalPrice(totalQuantity * cartProduct.getProduct().getPrice());
            //cartProductService.saveCartProduct(cartProduct);
        } else {
            List<CartProduct> cartProducts = cart.getCartProductList();

            CartProduct newCartProduct = new CartProduct();
            Product newProduct = productService.findById(productId);
            newCartProduct.setProduct(newProduct);
            newCartProduct.setQuantity(1);
            newCartProduct.setTotalPrice(newProduct.getPrice());

            cartProducts.add(newCartProduct);
            cart.setCartProductList(cartProducts);
            cartProductService.saveCartProduct(newCartProduct);

        }
        cartService.addCart(cart);


        model.addAttribute("product", product);
        System.out.println("testing" + productId);
        return "redirect:/product/list";
    }


    @GetMapping(value = "/cart")
    public String displayCartPage(Model model) {
        Customer loginCustomer = customerService.getLoginCustomer();
        if (loginCustomer.getCart() == null || loginCustomer.getCart().getCartProductList().size() == 0) {
            return "cart/error";
        } else {
            List<CartProduct> cartProducts = loginCustomer.getCart().getCartProductList();

            model.addAttribute("cartproducts", cartProducts);
            double sum = 0.0;
            for (CartProduct cartProduct : cartProducts) {
                sum += cartProduct.getTotalPrice();
            }
            model.addAttribute("sum", sum);
            return "cart/cart";
        }
    }

    @GetMapping(value = "/product/checkout")
    public String displayCheckoutPage(Model model) {
        Customer checkoutCustomer = customerService.getLoginCustomer();
        List<CartProduct> cartProducts = checkoutCustomer.getCart().getCartProductList();
        model.addAttribute("cartproducts", cartProducts);
        double sum = 0.0;
        for (CartProduct cartProduct : cartProducts) {
                sum += cartProduct.getTotalPrice();
            }
        Address address = new Address();
        if(checkoutCustomer.getAddress() != null) {
            address = checkoutCustomer.getAddress();
        }
        model.addAttribute("address",address);
        model.addAttribute("sum", sum);
        return "cart/checkout";
        }
    @PostMapping(value = "/cart/payment")
    public String displayPaymentPage(@ModelAttribute("address") Address address, Model model) {
        Customer customer = customerService.getLoginCustomer();
        customer.setAddress(address);
        addressService.saveAddress(address);
        customerService.saveCustomer(customer);
        return "cart/payment";
    }
    }


//    @GetMapping(value = "/edit/{studentId}")
//    public String displayEditFrom(@PathVariable Long studentId, Model model) {
//        Student student = studentService.findById(studentId);
//        if (student != null) {
//            model.addAttribute("student", student);
//            return "student/edit";
//        }
//        return "redirect:/student/list";
//    }








