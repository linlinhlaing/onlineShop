package edu.miu.cs.cs425.onlineShop.repository;

import edu.miu.cs.cs425.onlineShop.model.Cart;
import edu.miu.cs.cs425.onlineShop.model.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
    public CartProduct findByCartProductList(CartProduct cartProduct);
}
