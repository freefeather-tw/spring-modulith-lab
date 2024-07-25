package com.freefeather.modulith;

import com.freefeather.modulith.product.ProductDTO;
import com.freefeather.modulith.product.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args)
				.getBean(ProductService.class)
				.create(new ProductDTO("Product 1", "Description 1", 100));
	}

}
