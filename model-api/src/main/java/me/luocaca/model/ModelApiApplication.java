package me.luocaca.model;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableAutoConfiguration
//@EnableRabbit
@EnableAsync
@EnableScheduling
@MapperScan("me.luocaca.model.mapper")
public class ModelApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModelApiApplication.class, args);
	}
}
