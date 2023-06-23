package edu.miu.cs.cs425.onlineShop.Impl;

import edu.miu.cs.cs425.onlineShop.repository.ProductRepository;
import edu.miu.cs.cs425.onlineShop.Service.ProductService;
import edu.miu.cs.cs425.onlineShop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public List<Product> searchProductList(String Name) {
        return productRepository.findAllByNameContainingIgnoreCase(Name);
    }

}
