package br.com.fiap.teleorg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TeleorgApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeleorgApplication.class, args);
	}

}
