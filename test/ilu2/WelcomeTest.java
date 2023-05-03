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
		assertEquals("Hello, Amy and Bob",Welcome.welcome("amy,bob"));
		assertEquals("Hello, Amina and Mathilde",Welcome.welcome("amina,mathilde"));
		assertEquals("Hello, Tom and Emma",Welcome.welcome("Tom,emma"));
		assertEquals("Hello, Mathis and Nicolas",Welcome.welcome("Mathis,Nicolas"));
		
	}
	
	@Test 
	void EX_5() {
		assertEquals("Hello, Amy, Bob and Jerry", Welcome.welcome("Amy,bob,jerry"));
		assertEquals("Hello, Amina, Nicolas and Tom", Welcome.welcome("Amina,nicolas,tom"));
		assertEquals("Hello, Mathilde, Jean, Baptiste and Emma", Welcome.welcome("mathilde,Jean,baptiste,Emma"));
	}
	
	@Test
	void EX_6(){
		assertEquals("Hello, Amy and Jerry. AND HELLO, BOB !", Welcome.welcome("Amy,BOB,Jerry"));
		assertEquals("Hello, Jerry and Tom. AND HELLO, AMY AND BOB !", Welcome.welcome("AMY,BOB,Jerry,tom"));
		assertEquals("Hello, Jerry and Tom. AND HELLO, AMY AND BENOIT !", Welcome.welcome("AMY,jerry,tom,BENOIT"));
	}
	
	//jai change le nom de test car la consigne a ete change 
	@Test
	void ITER_7() {
		assertEquals("Hello, Bob, Amy and Jerry", Welcome.welcome("bob, amy, jerry"));
		assertEquals("Hello, Bob and Jerry. AND HELLO, AMY AND JACK !", Welcome.welcome("bob, AMY, jerry, JACK"));
		assertEquals("Hello, Tom. AND HELLO, BOB AND JERRY !", Welcome.welcome("Tom, BOB,JERRY"));
	}
	
	@Test
	//pas de modifications necessaires au code a ITER_8 car il gerait les espaces 
	void ITER_8() {
		assertEquals("Hello, Bob and Amy", Welcome.welcome("bob,       amy"));
		assertEquals("Hello, Bob, Amy and Tom", Welcome.welcome("bob,       amy,       Tom"));
		assertEquals("Hello, Tom and Jerry. AND HELLO, BOB AND AMY !", Welcome.welcome("    tom  , jerry, BOB, AMY    "));
	}
}
