package com.phcode.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.phcode.course.entities.Category;
import com.phcode.course.entities.Order;
import com.phcode.course.entities.Product;
import com.phcode.course.entities.User;
import com.phcode.course.entities.enums.OrderStatus;
import com.phcode.course.repositories.CategoryRepository;
import com.phcode.course.repositories.OrderRepository;
import com.phcode.course.repositories.ProductRepository;
import com.phcode.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;
    @Autowired
	private ProductRepository productRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Kitchen");
		Category cat3 = new Category(null, "Computers");
		
		
		
		Product p1 = new Product(null, "XboxOne", "Console de Games", 1100.00, "");
		Product p2 = new Product(null, "Monitor", "Monitor LCD", 700.00, "");
		Product p3 = new Product(null, "Prato", "Acessorio de cozinha", 100.20, "");
		
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		p1.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		
	
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID,u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT ,u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT ,u1);
		

		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		

	}
	

}
