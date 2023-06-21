package edu.miu.cs.cs425.onlineShop.Service;

import edu.miu.cs.cs425.onlineShop.model.Cart;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
    public abstract Cart addCart(Cart cart);


}
