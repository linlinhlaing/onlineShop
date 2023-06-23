package edu.miu.cs.cs425.onlineShop.repository;

import edu.miu.cs.cs425.onlineShop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p WHERE CONCAT(p.name, ' ', p.description, ' ', p.price) LIKE %?1%")
    public List<Product> search(String keyword);

    public List<Product> findByName(String name);

    List<Product> findAllByNameContainingIgnoreCase(String name);

}
