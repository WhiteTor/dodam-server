package com.dodam.dodam.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
@MapperScan(basePackages = "com.dodam.dodam.server.diary")
public class DodamServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DodamServerApplication.class, args);
	}

	@Bean
	public HiddenHttpMethodFilter httpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}
}
