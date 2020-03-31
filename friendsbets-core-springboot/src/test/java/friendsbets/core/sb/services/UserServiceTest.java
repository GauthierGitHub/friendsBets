package friendsbets.core.sb.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

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
	User u4 = new User("nickname4", "email4", "password4");
	List<User> lu = new ArrayList<User>();
	Set<User> friends = new HashSet<User>();
	
	public UserServiceTest() {
		lu.add(u1);
		lu.add(u2);
		lu.add(u3);
		lu.add(u4);
		friends.add(u2);
		friends.add(u3);
	}
			
	// reseting mocks after each use
	@AfterEach
	void resetMock() {
		reset(ur);
	}
	
//	@Test
	void save() { // TODO: make it works
		// configuring mock
		when(ur.save(u1)).thenReturn(Optional.of(Optional.of(u1).orElseThrow()).orElseThrow());
		// state test
		assertEquals(Optional.of(Optional.of(u1).orElseThrow()).orElseThrow()
				, us.save(u1)
				, "yo");
		// behavior test
		verify(ur, times(1)).save(u1);
		verify(ur, times(1)).findById(u1.getId());
		verifyNoMoreInteractions(ur);
	}
	
	@Test
	void findAll() {
		when(ur.findAll()).thenReturn(lu);
		assertEquals(lu, us.findAll(), "Searching all users should return a list of user");
		verify(ur, times(1)).findAll();
		verifyNoMoreInteractions(ur);
	}
	
	@Test
	void findById() {
		// configuring mock
		when(ur.findById(1)).thenReturn(Optional.of(u1));
		when(ur.findById(5)).thenReturn(Optional.empty());
		// state test
		assertEquals(u1, us.findById(1)
				, "Searching an existing user should return it.");
		assertThrows(NoSuchElementException.class, () -> us.findById(5)
				, "Searching a non-existing user should throw a NoSuchElementException exception");
		// behavior test
		verify(ur, times(1)).findById(1);
		verify(ur, times(1)).findById(5);
		verifyNoMoreInteractions(ur);
	}
	
	@Test
	void findByEmail() {
		when(ur.findByEmail("email1")).thenReturn(u1);
		assertEquals(u1, us.findByEmail("email1"));
		verify(ur, times(1)).findByEmail("email1");
		verifyNoMoreInteractions(ur);
	}

	@Test
	void findByEmailAndPassword() {
		when(ur.findByEmailAndPassword("email1", "password1")).thenReturn(u1);
		assertEquals(u1, us.findByEmailAndPassword("email1", "password1"));
		verify(ur, times(1)).findByEmailAndPassword("email1", "password1");
		verifyNoMoreInteractions(ur);
	}

	@Test
	void findFriends() {
		when(ur.findFriends(1)).thenReturn(friends);
		assertEquals(friends, us.findFriends(1));
		verify(ur, times(1)).findFriends(1);
		verifyNoMoreInteractions(ur);
	}
	
	@Test
	void addFriends() {
//		when(ur.addFriends(1, u2)); // repository write user one by one
		
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
