package ilu2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class WelcomeTest {

	@Test
	void EX_1() {
		assertEquals("Hello, Bob",Welcome.welcome("bob"));
		assertEquals("Hello, Bob",Welcome.welcome("Bob"));
		
		assertEquals("Hello, Amina",Welcome.welcome("amina"));
		assertEquals("Hello, Amina",Welcome.welcome("Amina"));
		
		assertEquals("Hello, Emma",Welcome.welcome("Emma"));
		assertEquals("Hello, Emma",Welcome.welcome("emma"));
	}
	
	
	@Test
	void EX_2() {
		assertEquals("Hello, my friend",Welcome.welcome("    "));
		assertEquals("Hello, my friend",Welcome.welcome(""));
		assertEquals("Hello, my friend",Welcome.welcome(null));
	}
	
	
	@Test
	void EX_3() {
		assertEquals("HELLO, JERRY !",Welcome.welcome("JERRY"));
		assertEquals("HELLO, MATHILDE !",Welcome.welcome("MATHILDE"));
		assertEquals("Hello, Tom",Welcome.welcome("Tom"));
		assertEquals("Hello, Emma",Welcome.welcome("emma"));
	}
	
	@Test
	void EX_4() {
		assertEquals("Hello, Amy, Bob",Welcome.welcome("amy,bob"));
		assertEquals("Hello, Amina, Mathilde",Welcome.welcome("amina,mathilde"));
		assertEquals("Hello, Tom, Emma",Welcome.welcome("Tom,emma"));
		assertEquals("Hello, Mathis, Nicolas",Welcome.welcome("Mathis,Nicolas"));
		
	}
}
