package edu.miu.cs.cs425.onlineShop.Service;

import edu.miu.cs.cs425.onlineShop.model.Order;
import edu.miu.cs.cs425.onlineShop.model.OrderLine;
import edu.miu.cs.cs425.onlineShop.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    public abstract Order addOrderLineToOrder(double total , List<OrderLine> orderLines);
}
