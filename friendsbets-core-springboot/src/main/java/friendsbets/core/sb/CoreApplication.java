package friendsbets.core.sb;

import org.jboss.logging.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import friendsbets.core.sb.services.UserService;

@SpringBootApplication
@EnableAutoConfiguration
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
		Logger.getLogger("		CORE APP").info("		!! CORE IS RUNNING !!");
	}
	
	@Bean
	public CommandLineRunner test(UserService ms) {
		return (args2) -> {
//			System.out.println(ms.findAll());
//			System.out.println(ms.findById(1000));
			Logger.getLogger(getClass()).info("		!! CORE IS RUNNING !!");
		};
	}
}
