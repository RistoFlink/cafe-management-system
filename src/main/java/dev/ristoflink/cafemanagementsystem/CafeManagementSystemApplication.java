package dev.ristoflink.cafemanagementsystem;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class CafeManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeManagementSystemApplication.class, args);
	}

	@Configuration
	public class EnvConfig {

		@Bean
		public Dotenv dotenv() {
			return Dotenv.configure().load();
		}
	}

}
