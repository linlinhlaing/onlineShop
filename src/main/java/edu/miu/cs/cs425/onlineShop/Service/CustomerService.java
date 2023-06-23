package edu.miu.cs.cs425.onlineShop.Service;

import edu.miu.cs.cs425.onlineShop.model.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    public abstract Customer getById(Long customerId);
    public abstract Customer saveCustomer(Customer customer);
    public abstract Customer getLoginCustomer();
}
