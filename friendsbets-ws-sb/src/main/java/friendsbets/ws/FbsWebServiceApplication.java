package friendsbets.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import friendsbets.core.sb.CoreApplication;

@SpringBootApplication
@Import(CoreApplication.class)
public class FbsWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FbsWebServiceApplication.class, args);
	}

//	//@SpringBootApplication
//	public class RestServiceCorsApplication {
//	
//		public static void main(String[] args) {
//			SpringApplication.run(RestServiceCorsApplication.class, args);
//		}
	//
//		@Bean
//		public WebMvcConfigurer corsConfigurer() {
//			return new WebMvcConfigurer() {
//				@Override
//				public void addCorsMappings(CorsRegistry registry) {
//					registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:9000");
//				}
//			};
//		}
//
//	}
}
