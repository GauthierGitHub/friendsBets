package friendsbets.core.sb.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Set;

import org.junit.jupiter.api.Test;

@SpringBootTest
class UserTest {

	User u;

//	@Test
//	void testUser() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testUserStringStringString() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testUserIntStringStringString() {
//		fail("Not yet implemented"); // TODO
//	}

	// TODO: test constructor

	@Test
	void testGetSetId() {
		// Given
		long idConstructor = 1L;
		long idSetter = Long.MAX_VALUE;
		String nickname = null;
		String password = ""; // Can throw NullPointerException with class Password
		String email = null;
		String picturePath = null;
		Set<Bet> betsInitialized = null;
		Set<Bet> betsFollowed = null;
		Set<Group> grpList = null;
		Set<User> friends = null;
		String token = null;
		LocalDateTime tokenLastUsed = null;
		// When
		User user = new User(idConstructor, nickname, password, email, picturePath, betsInitialized, betsFollowed,
				grpList, friends, token, tokenLastUsed); // Test constructor too.
		// Then
		assertEquals(idConstructor, user.getId(), "getId() from constructor.");
		assertDoesNotThrow(() -> user.setId(idSetter), "setId() after constructor.");
		assertEquals(idSetter, user.getId(), "getId() from setter.");
	}

	@Test
	void testGetSetNickname() {
		// Given
		long id = 0L; // Value used by no args constructor.
		String nicknameConstructor = "a";
		String nicknameSetter= "a";
		String password = "";
		String email = null;
		String picturePath = null;
		Set<Bet> betsInitialized = null;
		Set<Bet> betsFollowed = null;
		Set<Group> grpList = null;
		Set<User> friends = null;
		String token = null;
		LocalDateTime tokenLastUsed = null;
		// When
		User user = new User(id, nicknameConstructor, password, email, picturePath, betsInitialized, betsFollowed,
				grpList, friends, token, tokenLastUsed); // Test constructor too.
		// Then
		assertEquals(nicknameConstructor, user.getNickname(), "getNickname() from constructor.");
		assertDoesNotThrow(() -> user.setNickname(nicknameSetter), "setNickname() after constructor.");
		assertEquals(nicknameSetter, user.getNickname(), "getNickname() from setter.");
	}

//	@Test
//	void testSetNickname() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testGetPassword() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testSetPassword() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testGetEmail() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testSetEmail() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testGetGrpList() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testSetGrpList() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testGetPicturePath() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testSetPicturePath() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testGetBetsInitialized() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testSetBetsInitialized() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testGetBetsFollowed() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testSetBetsFollowed() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testGetFriends() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testSetFriends() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testGetToken() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testSetToken() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testGetTokenLastUsed() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testSetTokenLastUsed() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testToString() {
//		fail("Not yet implemented"); // TODO
//	}

}
