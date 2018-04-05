package fr.hardis.formation.poe.fpgapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import fr.hardis.formation.poe.fpgapi.dao.UserDao;

@SpringBootApplication
public class FpgApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FpgApiApplication.class, args);
	}
}
