package vn.edu.iuh.fit.lab07;

import net.datafaker.Faker;
import net.datafaker.providers.base.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.lab07.backend.enums.ProductStatus;
import vn.edu.iuh.fit.lab07.backend.models.Product;
import vn.edu.iuh.fit.lab07.backend.models.ProductPrice;
import vn.edu.iuh.fit.lab07.backend.repositories.CustomerRepository;
import vn.edu.iuh.fit.lab07.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.lab07.backend.services.ProductService;

import java.util.ArrayList;

@SpringBootApplication
public class Lab07Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab07Application.class, args);
	}

	@Autowired
	private ProductService productService;

//	@Bean
	CommandLineRunner createSampleCustomer(){
		return args -> {
			Faker faker = new Faker();
			Device device = faker.device();
			for (int i = 0; i < 100; i++) {
				Product product = new Product(
						device.modelName(),
						faker.lorem().paragraph(30),
						"piece",
						device.manufacturer(),
						ProductStatus.ACTIVE
				);
				productService.add(product);
			}
		};
	}
}
