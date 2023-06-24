package edu.miu.cs.cs425.onlineShop.Service;

import edu.miu.cs.cs425.onlineShop.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public abstract List<Product> getAllProduct();
    public abstract Product findById(Long productId);

    List<Product> searchProductList(String name);
}
