package friendsbets.core.sb.services;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import friendsbets.core.sb.models.User;

@SpringBootTest
public class UserServiceSpringBootTest {
	
	@Autowired
	UserService us; //tested class
	
	@Mock
	User u1 = new User("a", "a", "a");
	
	@InjectMocks
	GroupService gs;

}
