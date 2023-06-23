package edu.miu.cs.cs425.onlineShop.Impl;

import edu.miu.cs.cs425.onlineShop.Service.OrderLineService;
import edu.miu.cs.cs425.onlineShop.model.OrderLine;
import edu.miu.cs.cs425.onlineShop.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderLineServiceImpl implements OrderLineService {
    @Autowired
    OrderLineRepository orderLineRepository;
    @Override
    public OrderLine saveOrderLine(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }
}
