package com.example.rediscache;

import com.example.rediscache.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;

@SpringBootApplication
public class RediscacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(RediscacheApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(ProductService productService) {
		return args -> {
			System.out.println(productService.getProductById(1L)); // Lần 1: lấy từ DB
			System.out.println(productService.getProductById(1L)); // Lần 2: lấy từ cache
			System.out.println(productService.getProductById(2L)); // Lần 3: lấy từ DB
			System.out.println(productService.getProductById(2L)); // Lần 4: lấy từ cache
		};
	}

}
