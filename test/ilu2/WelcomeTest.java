package ilu2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class WelcomeTest {
	
	/*EX_1 : Hello, Bob*/
	@Test
	void EX_1() {
		assertEquals("Hello, Bob",Welcome.welcome("bob"));
		assertEquals("Hello, Bob",Welcome.welcome("Bob"));
		
		assertEquals("Hello, Amina",Welcome.welcome("amina"));
		assertEquals("Hello, Amina",Welcome.welcome("Amina"));
		
		assertEquals("Hello, Emma",Welcome.welcome("Emma"));
		assertEquals("Hello, Emma",Welcome.welcome("emma"));
	}
	
	
	/*EX_2 : Gestion des null et des chaînes vides*/
	@Test
	void EX_2() {
		assertEquals("Hello, my friend",Welcome.welcome("    "));
		assertEquals("Hello, my friend",Welcome.welcome(""));
		assertEquals("Hello, my friend",Welcome.welcome(null));
	}
	
	
	/*EX_3 : Gestion des cris*/
	@Test
	void EX_3() {
		assertEquals("HELLO, JERRY !",Welcome.welcome("JERRY"));
		assertEquals("HELLO, MATHILDE !",Welcome.welcome("MATHILDE"));
		assertEquals("Hello, Tom",Welcome.welcome("Tom"));
		assertEquals("Hello, Emma",Welcome.welcome("emma"));
	}
	
	/*EX_4 : Gestion deux noms en input.*/
	@Test
	void EX_4() {
		assertEquals("Hello, Amy and Bob",Welcome.welcome("amy,bob"));
		assertEquals("Hello, Amina and Mathilde",Welcome.welcome("amina,mathilde"));
		assertEquals("Hello, Tom and Emma",Welcome.welcome("Tom,emma"));
		assertEquals("Hello, Mathis and Nicolas",Welcome.welcome("Mathis,Nicolas"));
		
	}
	
	/*EX_5 : Gestion de plusieurs noms en input.*/
	@Test 
	void EX_5() {
		assertEquals("Hello, Amy, Bob and Jerry", Welcome.welcome("Amy,bob,jerry"));
		assertEquals("Hello, Amina, Nicolas and Tom", Welcome.welcome("Amina,nicolas,tom"));
		assertEquals("Hello, Mathilde, Jean, Baptiste and Emma", Welcome.welcome("mathilde,Jean,baptiste,Emma"));
	}
	
	
	/*EX_6 : Gestion des cris lorsqu’il y a plusieurs noms.*/
	@Test
	void EX_6(){
		assertEquals("Hello, Amy and Jerry. AND HELLO, BOB !", Welcome.welcome("Amy,BOB,Jerry"));
		assertEquals("Hello, Jerry and Tom. AND HELLO, AMY AND BOB !", Welcome.welcome("AMY,BOB,Jerry,tom"));
		assertEquals("Hello, Jerry and Tom. AND HELLO, AMY AND BENOIT !", Welcome.welcome("AMY,jerry,tom,BENOIT"));
		assertEquals("HELLO, TOM, JERRY AND AMINA !", Welcome.welcome("TOM, JERRY, AMINA"));
		assertEquals("Hello, Tom. AND HELLO, JERRY !", Welcome.welcome("tom, JERRY"));

	}
	
	
	/*ITER_7 : Gestion des listes de noms en ajoutant un “and” pour le dernier nom.*/
	//jai change le nom de test car la consigne a ete change 
	@Test
	void ITER_7() {
		assertEquals("Hello, Bob, Amy and Jerry", Welcome.welcome("bob, amy, jerry"));
		assertEquals("Hello, Bob and Jerry. AND HELLO, AMY AND JACK !", Welcome.welcome("bob, AMY, jerry, JACK"));
		assertEquals("Hello, Tom. AND HELLO, BOB AND JERRY !", Welcome.welcome("Tom, BOB,JERRY"));
	}
	
	
	/*ITER_8 : Supprimer les espaces inutiles.*/
	@Test
	//pas de modifications necessaires au code a ITER_8 car il gerait les espaces 
	void ITER_8() {
		assertEquals("Hello, Bob and Amy", Welcome.welcome("bob,       amy"));
		assertEquals("Hello, Bob, Amy and Tom", Welcome.welcome("bob,       amy,       Tom"));
		assertEquals("Hello, Tom and Jerry. AND HELLO, BOB AND AMY !", Welcome.welcome("    tom  , jerry, BOB, AMY    "));
	}
	
	
	/*ITER_9 : Indiquer le nombre de fois qu’un nom apparaît dans la chaîne de caractères.*/
	@Test
	void ITER_9() {
		assertEquals("Hello, Bob (x3) and Amy. AND HELLO, JERRY (x2) !", Welcome.welcome("bob, JERRY, amy, bob, JERRY, bob"));
		assertEquals("Hello, Tom (x2), Jerry (x3) and Jack (x2). AND HELLO, AMY (x2), JACK AND BOB !", Welcome.welcome(" tom, AMY, jerry, JACK, BOB, jack, jack, tom, jerry, AMY, jerry"));
		assertEquals("Hello, Ilu (x5)", Welcome.welcome(" ilu,    Ilu,    ilu,    ilu,  Ilu"));
		assertEquals("Hello, Ilu (x3) and Test. AND HELLO, INFORMATIQUE (x2) !", Welcome.welcome("ilu, INFORMATIQUE, test, Ilu, INFORMATIQUE,     ilu"));
	}
	
	
	/*ITER_10 : Yoda*/
	
	@Test
	void ITER_10() {
		assertEquals("Bob, Yoda and Amy, Hello. AND HELLO, JERRY !", Welcome.welcome("bob, yoda, amy, JERRY"));
		assertEquals("Amy, Bob (x2) and Yoda, Hello", Welcome.welcome("   amy  , bob  , yoda,bob "));
		assertEquals("Hello, Amy (x2). AND TOM (x4) AND YODA, HELLO !", Welcome.welcome("amy,  TOM ,YODA, amy,TOM,TOM,TOM  "));
		assertEquals("Bob, Yoda and Amy, Hello. AND JERRY AND YODA, HELLO !", Welcome.welcome("bob, yoda, amy, JERRY, YODA"));

	}
}
