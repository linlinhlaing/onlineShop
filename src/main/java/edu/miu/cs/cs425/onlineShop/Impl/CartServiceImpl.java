package edu.miu.cs.cs425.onlineShop.Impl;

import edu.miu.cs.cs425.onlineShop.Service.CartService;
import edu.miu.cs.cs425.onlineShop.model.Cart;
import edu.miu.cs.cs425.onlineShop.model.CartProduct;
import edu.miu.cs.cs425.onlineShop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;
    @Override
    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }



}
