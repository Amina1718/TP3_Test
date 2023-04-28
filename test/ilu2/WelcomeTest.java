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
	
	@Test 
	void EX_5() {
		assertEquals("Hello, Amy, Bob, Jerry", Welcome.welcome("Amy,bob,jerry"));
		assertEquals("Hello, Amina, Nicolas, Tom", Welcome.welcome("Amina,nicolas,tom"));
		assertEquals("Hello, Mathilde, Jean, Baptiste, Emma", Welcome.welcome("mathilde,Jean,baptiste,Emma"));
	}
	
	@Test
	void EX_6(){
		assertEquals("Hello, Amy, Jerry. AND HELLO, BOB !", Welcome.welcome("Amy,BOB,Jerry"));
		assertEquals("Hello, Jerry, Tom. AND HELLO, AMY, BOB !", Welcome.welcome("AMY,BOB,Jerry,tom"));
		assertEquals("Hello, Jerry, Tom. AND HELLO, AMY, BENOIT !", Welcome.welcome("AMY,jerry,tom,BENOIT"));
		assertEquals("HELLO, MATHILDE, NICOLAS, TOM, MATHIS !", Welcome.welcome("MATHILDE,NICOLAS,TOM,MATHIS"));
		assertEquals("HELLO, LEO, MATHIS !", Welcome.welcome("LEO,MATHIS"));
	}
	
}
