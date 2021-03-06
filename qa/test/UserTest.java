import java.util.List;

import models.*;

import org.junit.Before;
import org.junit.Test;

import play.test.Fixtures;
import play.test.UnitTest;

public class UserTest extends UnitTest {

	@Before
	public void setup() {
		Fixtures.deleteAll();
	}

	@Test
	public void createUser() {
		User user = new User("Jack", "test@mail.com", "password").save();
		assertTrue(user != null);
		assertEquals(user, User.findById(user.id));
	}

	@Test
	public void shouldBeCalledJack() {
		new User("Jack", "test@mail.com", "password").save();
		List<User> user = User.find("byName", "Jack").fetch();
		assertEquals(1, user.size());
		assertEquals(user.get(0).name(), "Jack");
		assertEquals(user.get(0).email(), "test@mail.com");
	}

	@Test
	public void shouldHaveAPassword() {
		new User("Jack", "test@mail.com", "password").save();
		List<User> user = User.find("byNameAndPassword", "Jack", "password")
				.fetch();
		assertEquals("password", user.get(0).password());

	}

	@Test
	public void testAuthenticateMethods() {
		User user = new User("Jack", "test@mail.com", "password").save();
		assertEquals(user, User.connect("Jack", "password"));
		assertEquals(null, User.connect("something", "noone"));
	}

	@Test
	public void testExistsMethod() {
		new User("Jack", "test@mail.com", "password").save();
		assertTrue(User.exists("Jack"));
		assertFalse(User.exists("john"));

	}

	@Test
	public void deleteUser() {
		User user = new User("Jack", "test@mail.com", "password").save();
		assertEquals(1, User.count());
		user.delete();
		assertEquals(0, User.count());
	}
	
	@Test
	public void reputation() {
		User jack = new User("Jack", "test@mail.com", "password").save();
		assertEquals(0, jack.reputation());
		User bill = new User("Bill", "test@mail.com", "password").save();
		Question question = jack.addQuestion("A title", "My first question");
		question.voteUp(bill);
		assertEquals(1, jack.reputation());
		question.voteDown(bill);
		assertEquals(-1, jack.reputation());
	}

}
