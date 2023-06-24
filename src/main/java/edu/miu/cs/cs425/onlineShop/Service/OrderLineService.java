package edu.miu.cs.cs425.onlineShop.Service;

import edu.miu.cs.cs425.onlineShop.model.CartProduct;
import edu.miu.cs.cs425.onlineShop.model.OrderLine;
import org.springframework.stereotype.Service;

@Service
public interface OrderLineService {
    public abstract OrderLine saveOrderLine(CartProduct cartProduct);
}
