package edu.miu.cs.cs425.onlineShop.Service;

import edu.miu.cs.cs425.onlineShop.model.CartProduct;
import org.springframework.stereotype.Service;

@Service
public interface CartProductService {
    public abstract CartProduct saveCartProduct(CartProduct cartProduct);
    public abstract CartProduct findById(Long cartProductId);
    public abstract void removeByCartProductId(Long cartProductId);
}
