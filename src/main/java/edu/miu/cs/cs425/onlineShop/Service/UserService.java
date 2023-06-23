package edu.miu.cs.cs425.onlineShop.Service;

import edu.miu.cs.cs425.onlineShop.model.User;
import edu.miu.cs.cs425.onlineShop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Boolean ifUserExists(String username, String password) {
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        User user = userRepository.findByUsernameAndPassword(username, password);
        System.out.println("User from database::: " + user);
        return user != null ? true : false;
    }

}
