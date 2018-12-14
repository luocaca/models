package me.luocaca.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration
//@MapperScan("me.luocaca.mapper")
public class ModelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModelApiApplication.class, args);
	}
}
