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

}
