package edu.miu.cs.cs425.onlineShop;

import edu.miu.cs.cs425.onlineShop.repository.CartProductRepository;
import edu.miu.cs.cs425.onlineShop.repository.CustomerRepository;
import edu.miu.cs.cs425.onlineShop.model.*;
import edu.miu.cs.cs425.onlineShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.List;
import java.util.Optional;

@SpringBootApplication

@EnableJpaRepositories("edu.miu.cs.cs425.onlineShop.*")
@ComponentScan(basePackages = { "edu.miu.cs.cs425.onlineShop.*" })
@EntityScan("edu.miu.cs.cs425.onlineShop.*")
public class OnlineShopApplication implements CommandLineRunner {
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CartProductRepository cartProductRepository;
	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(OnlineShopApplication.class, args);
	}

	public void productGenerate() {


		String[] descriptions = {
				"Perfect for everyday use",
				"Ideal for students and professionals",
				"High-quality and durable",
				"Designed for comfort and efficiency",
				"Sleek and modern design",
				"Enhance your productivity",
				"Organize your workspace with style",
				"Premium materials for long-lasting use",
				"Versatile and practical",
				"Stay organized and focused"
		};

		String[] products = {
				"Pen",
				"Notebook",
				"Stapler",
				"Highlighter",
				"Paper Clips",
				"Correction Tape",
				"Desk Organizer",
				"Sticky Notes",
				"Binder Clips",
				"Whiteboard Marker",
				"Calculator",
				"Scissors",
				"Ruler",
				"Index Cards",
				"Pencil Sharpener",
				"Eraser",
				"File Folders",
				"Push Pins",
				"Paper Shredder",
				"Desk Calendar"
		};

		Random random = new Random();

		DecimalFormat df = new DecimalFormat("0.00");

		for (int i = 0; i < 20; i++) {
			String desc = descriptions[random.nextInt(descriptions.length)];
			String product = products[random.nextInt(products.length)];
			String image = "/img/" + product.replace(" ","_").toLowerCase() + ".jpg";
			double price = Double.parseDouble(String.valueOf(random.nextInt(100)));
			productRepository.save(new Product(product, price, desc, image));
		}
	}

	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("1000N", "Fairfield", "Iowa", "52557");
		Cart cart = new Cart(20.5);
		productGenerate();
//		for (int i = 0; i <= 10; i++) {
//			productRepository.save(new Product("orange" + i, 5.0, "It is sweet", ""));
//
//		}
		Customer customer = new Customer("Lin Lin Hlaing", "linlin@gmail.com", "12345");
		customerRepository.save(customer);
//		Product product =new Product("");
//		customer.setCart(cart);
	}

}
