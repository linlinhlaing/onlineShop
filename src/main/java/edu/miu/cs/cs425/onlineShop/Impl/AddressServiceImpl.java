package edu.miu.cs.cs425.onlineShop.Impl;

import edu.miu.cs.cs425.onlineShop.Service.AddressService;
import edu.miu.cs.cs425.onlineShop.model.Address;
import edu.miu.cs.cs425.onlineShop.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }
}
