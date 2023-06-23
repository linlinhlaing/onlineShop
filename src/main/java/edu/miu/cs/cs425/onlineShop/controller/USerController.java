package edu.miu.cs.cs425.onlineShop.controller;

import edu.miu.cs.cs425.onlineShop.Service.UserService;
import edu.miu.cs.cs425.onlineShop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/login")
public class USerController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public String processLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        Boolean userExists = userService.ifUserExists(username, password);
        System.out.println("Does user exist:::" + userExists);
        if(userExists) return "home/index";
        else return "login/login";
    }

//    @GetMapping("/login")
//    public String showLoginPage() {
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
//        // Perform authentication logic here
//        // If authentication is successful, redirect to a success page
//        // If authentication fails, redirect back to the login page with an error message
////        if (authenticate(username, password)) {
////            return "redirect:/success";
////        } else {
////            model.addAttribute("error", "Invalid username or password");
////            return "login";
////        }
//        return null;
//    }
//
//    @GetMapping("/success")
//    public String showSuccessPage() {
//        return "success";
//    }
}
