package fr.pomverte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:spring/*.xml")
@SpringBootApplication
public class SpringIntSoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntSoapApplication.class, args);
	}
}
