package edu.miu.cs.cs425.onlineShop.repository;

import edu.miu.cs.cs425.onlineShop.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine,Long> {

}
