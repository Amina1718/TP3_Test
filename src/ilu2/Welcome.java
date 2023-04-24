package ilu2;

public class Welcome {
	public static String welcome(String input) {
		 return "Hello, " + input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
