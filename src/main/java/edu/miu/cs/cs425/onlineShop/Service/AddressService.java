package edu.miu.cs.cs425.onlineShop.Service;

import edu.miu.cs.cs425.onlineShop.model.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    public abstract Address saveAddress(Address address);
}
