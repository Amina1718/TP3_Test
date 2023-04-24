package ilu2;

public class Welcome {
	public static String welcome(String input) {
		if (input==null || input.trim().isEmpty()) {
			return "Hello, my friend";
		}
		StringBuilder chaine= new StringBuilder();
		chaine.append("Hello, ");
		input= input.substring(0, 1).toUpperCase() + input.substring(1);
		chaine.append(input);
		return chaine.toString();
	}
}