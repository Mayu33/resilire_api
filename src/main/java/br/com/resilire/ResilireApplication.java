package br.com.resilire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class ResilireApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResilireApplication.class, args);
	}

}
