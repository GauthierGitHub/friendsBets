package friendsbets.ws;

import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import friendsbets.core.sb.CoreApplication;

@SpringBootApplication
@Import(CoreApplication.class)
public class FbsWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FbsWebServiceApplication.class, args);
		Logger.getLogger("webservice main").info("		!! WS IS RUNNING !!");
	}

	/**
	 * Enabling CORS (Cross-Origin Resource Sharing) from angular
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
	         @Override
	         public void addCorsMappings(CorsRegistry registry) {
	        	 registry.addMapping("/**")
					.allowedMethods("GET","POST","PUT","UPDATE","DELETE","OPTIONS")
					.allowedOrigins("http://localhost:4200");
	         }
		};
	}
}
