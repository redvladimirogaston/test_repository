import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ApplicationTest {

	@Test
	void testMakeGreeting() {
		Application app = new Application();
		assertNotNull(app.makeGreeting());
		assertEquals(app.makeGreeting(), "Hello");
	}

}
