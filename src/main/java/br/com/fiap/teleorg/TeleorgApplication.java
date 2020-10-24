package br.com.fiap.teleorg;

import br.com.fiap.teleorg.domain.Hospital;
import br.com.fiap.teleorg.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TeleorgApplication {

	@Bean
	public CommandLineRunner init (@Autowired HospitalRepository repository){
		return args -> {
			repository.save(new Hospital("Sirio Libanes", "28.510.268/0001-92", "São Paulo", "Rua Dona Adma Jafet, 91", "Bela Vista", 1133940200));
			repository.save(new Hospital("Albert Einstein", "10.585.152/0001-57", "São Paulo", "Av. Albert Einstein, 627", "Jardim Leonor", 1121511233 ));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(TeleorgApplication.class, args);
	}

}
