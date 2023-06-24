package edu.miu.cs.cs425.onlineShop.Impl;

import edu.miu.cs.cs425.onlineShop.Service.OrderLineService;
import edu.miu.cs.cs425.onlineShop.model.CartProduct;
import edu.miu.cs.cs425.onlineShop.model.OrderLine;
import edu.miu.cs.cs425.onlineShop.repository.CartProductRepository;
import edu.miu.cs.cs425.onlineShop.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderLineServiceImpl implements OrderLineService {
    @Autowired
    OrderLineRepository orderLineRepository;
    @Override
    public OrderLine saveOrderLine(CartProduct cartProduct) {
        OrderLine orderLine = new OrderLine();
        orderLine.setOrderLineId(cartProduct.getCartProductId());
        orderLine.setQuantity(cartProduct.getQuantity());
        orderLine.setTotalPrice(cartProduct.getTotalPrice());
        orderLine.setProduct(cartProduct.getProduct());
        return orderLineRepository.save(orderLine);
    }
}
