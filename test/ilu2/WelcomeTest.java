package ilu2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class WelcomeTest {

	@Test
	void EX_01() {
		assertEquals(Welcome.welcome("bob"), "Hello, Bob");
		assertEquals(Welcome.welcome("Bob"), "Hello, Bob");
		assertEquals(Welcome.welcome("amina"), "Hello, Amina");
		assertEquals(Welcome.welcome("Amina"), "Hello, Amina");
		assertEquals(Welcome.welcome("Emma"), "Hello, Emma");
		assertEquals(Welcome.welcome("emma"), "Hello, Emma");
	}
	
	

}
