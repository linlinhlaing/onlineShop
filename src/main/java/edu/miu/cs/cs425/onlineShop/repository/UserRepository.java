package edu.miu.cs.cs425.onlineShop.repository;

import edu.miu.cs.cs425.onlineShop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameAndPassword(String username, String password);

}
