package tk.puldev.ws.fridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class RefrigeratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RefrigeratorApplication.class, args);
	}
}
