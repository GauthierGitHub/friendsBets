package friendsbets.core.sb.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import friendsbets.core.sb.models.User;
import friendsbets.core.sb.repositories.UserRepository;

@SpringBootTest
class UserServiceTest {
	
	// mock objects
	@Mock
	UserRepository ur;
	
	// object under test
	@InjectMocks
	UserService us;
	
	// data fixtures
	User u1 = new User(1, "nickname1", "email1", "password1");
	User u2 = new User(1, "nickname2", "email2", "password2");
	User u3 = new User(1, "nickname3", "email3", "password3");
	
	// reseting mocks after each use
	@AfterEach
	void resetMock() {
		reset(ur);
	}
	
	@Test
	void findById() {
		// configuring mock
		when(ur.findById(1)).thenReturn(Optional.of(u1));
		when(ur.findById(5)).thenReturn(Optional.empty());
		// state test
		assertEquals(u1, us.findById(1), "Searching an existing user should return it.");
		assertThrows(NoSuchElementException.class, () -> us.findById(5), "Searching a non-existing user should throw a NoSuchElementException exception");
		// behavior test
		verify(ur, times(1)).findById(1);
		verify(ur, times(5)).findById(5);
		verifyNoMoreInteractions(ur);
	}
	

//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}
//
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}
//
//	@Test
//	void testSave() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindAll() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindByEmail() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindByUserMailAndPassword() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindFriends() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testAddFriends() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindAllOthers() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindByNicknameOrEmailLike() {
//		fail("Not yet implemented");
//	}

}
