package edu.miu.cs.cs425.onlineShop.controller;

import edu.miu.cs.cs425.onlineShop.Service.CartProductService;
import edu.miu.cs.cs425.onlineShop.Service.CartService;
import edu.miu.cs.cs425.onlineShop.Service.CustomerService;
import edu.miu.cs.cs425.onlineShop.Service.ProductService;
import edu.miu.cs.cs425.onlineShop.model.Cart;
import edu.miu.cs.cs425.onlineShop.model.CartProduct;
import edu.miu.cs.cs425.onlineShop.model.Customer;
import edu.miu.cs.cs425.onlineShop.model.Product;
import edu.miu.cs.cs425.onlineShop.repository.CartProductRepository;
import edu.miu.cs.cs425.onlineShop.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = {"","/product"})
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
    @GetMapping(value = "/list")
    public String getProductList(Model model) {
        List<Product> products = productService.getAllProduct();
        System.out.println("hello "+products);
        model.addAttribute("products" , products);
        System.out.println("hello"+products);
        return "product/list";
    }
    @PostMapping(value = "/addToCart/{productId}")
    public String displayAddToCartPage(@PathVariable("productId") Long productId, Model model) {
        Product product = productService.findById(productId);
        Customer customer = customerService.getById(1l);
        Cart cart = customer.getCart();
        if(cart == null) {
            Cart newCart = new Cart(0);
            customer.setCart(newCart);

            customerService.saveCustomer(customer);
            cart = customer.getCart();
        }

        if(cart.getCartProductList() == null) {
            List<CartProduct> cartPds = new ArrayList<>();
            cart.setCartProductList(cartPds);
        }

        List<CartProduct> result = cart.getCartProductList().stream().filter(
                    cartProduct1 -> cartProduct1.getProduct().getId() == productId
            ).toList();

        if(result.size() >0) {
            CartProduct cartProduct = result.get(0);
            int totalQuantity =cartProduct.getQuantity()+1;
            cartProduct.setQuantity(totalQuantity);
            cartProduct.setTotalPrice(totalQuantity*cartProduct.getTotalPrice());
            //cartProductService.saveCartProduct(cartProduct);
        }
        else {
            List<CartProduct> cartProducts = cart.getCartProductList();
            int totalQuantity = 1;
            CartProduct newCartProduct= new CartProduct();
            Product newProduct = productService.findById(productId);
            newCartProduct.setProduct(newProduct);
            newCartProduct.setQuantity(1);
            newCartProduct.setTotalPrice(newProduct.getPrice());

            cartProducts.add(newCartProduct);

            cart.setCartProductList(cartProducts);

        }
        cartService.addCart(cart);


        model.addAttribute("product",product);
        System.out.println("testing"+productId);
        return "redirect:/product/list";
    }
}
