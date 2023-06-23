package edu.miu.cs.cs425.onlineShop.Impl;

import edu.miu.cs.cs425.onlineShop.Service.CustomerService;
import edu.miu.cs.cs425.onlineShop.model.Customer;
import edu.miu.cs.cs425.onlineShop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Customer getById(Long customerId) {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getLoginCustomer() {
        return customerRepository.findById(1l).orElseThrow(null);
    }


}
