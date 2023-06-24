package edu.miu.cs.cs425.onlineShop.repository;

import edu.miu.cs.cs425.onlineShop.model.CartProduct;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartProductRepository extends JpaRepository<CartProduct,Long> {
    @Modifying
    @Transactional
    @Query(value ="delete from carts_cart_product WHERE cart_product_list_cart_product_id = :cartProductId",nativeQuery = true)
    public void deleteCarts_cart_product(@Param("cartProductId")Long cartProductId);

}
