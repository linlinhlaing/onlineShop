package edu.miu.cs.cs425.onlineShop.controller;

import edu.miu.cs.cs425.onlineShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "")
@Controller
public class HomeController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String login() {
        //return "home/index";
        return "login/login";
    }
//    @PostMapping("/")
//    public String processLogin(@RequestBody LoginRequestDTO loginData) {
//        System.out.println("login DTO Data::: " + loginData.username);
//        return "login/login";
//    }

    @GetMapping("/productList")
    public String getProduct(Model model) {
//        List<Product> products = productRepository.findAll();
//        System.out.println("hello "+products);
//        model.addAttribute("products" , products);
//        System.out.println("hello"+products);
//        System.out.println("testing");
//        return "home/index";
        return null;
    }

    @GetMapping("/footer")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "fragments/footer";
    }

    @GetMapping(value = "/about")
    public String displayAboutPage() {
        return "home/about";
    }
    @GetMapping(value = "/contact")
    public String displayContactPage() {
        return "home/contact";
    }
    @PostMapping(value = "/willContact")
    public String displayWillContact(){
        return "home/willContact";
    }


}
