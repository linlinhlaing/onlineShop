package edu.miu.cs.cs425.onlineShop.Impl;

import edu.miu.cs.cs425.onlineShop.Service.OrderLineService;
import edu.miu.cs.cs425.onlineShop.Service.OrderService;
import edu.miu.cs.cs425.onlineShop.model.CartProduct;
import edu.miu.cs.cs425.onlineShop.model.Order;
import edu.miu.cs.cs425.onlineShop.model.OrderLine;
import edu.miu.cs.cs425.onlineShop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Override
    public Order addOrderLineToOrder(double total, List<OrderLine> orderLines) {
        Random random = new Random();
        Order order = new Order();
        order.setDate(LocalDate.now());
        order.setStatus("success");
        order.setPaymentMethod("card");
        order.setTotalPrice(total);
        order.setInvoiceNo("INV" + random.nextInt(10000));
        order.setOrderLineList(orderLines);
        return orderRepository.save(order);
    }
}
