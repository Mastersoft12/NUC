package com.bancolombia.homologador.Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"com.bancolombia.homologador.Controller","com.bancolombia.homologador.persistencia.Persistencia"})
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControllerApplication.class, args);
	}

}
