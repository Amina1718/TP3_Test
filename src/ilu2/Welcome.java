package ilu2;


public class Welcome {
	public static String welcome(String input) {
	    if (input == null || input.trim().isEmpty()) {
	        return "Hello, my friend";
	    }

	    StringBuilder phrase = new StringBuilder("Hello, ");
	    String[] noms = input.split(",");
	    StringBuilder majuscule = new StringBuilder(phrase.toString().toUpperCase());

	    if (GestionPrenoms(noms, phrase, majuscule)) {
			return GestionCrie(phrase,majuscule,input).toString(); //ici , au moins un prenom en majuscule
		}
		
		return phrase.toString();
	}

	// Gère la virgule à la fin de la phrase, en enlevant la virgule si elle n'est pas nécessaire
	private static void GestionVirgule(StringBuilder string) {
		if(string.lastIndexOf(",") == string.length()-2) {
			string.delete((string.length())-2, string.length());
		}
		else {
			string.delete((string.length())-1, string.length());
		}
	}
	
	
	private static StringBuilder GestionCrie(StringBuilder phrase,StringBuilder maj, String input) {
		maj.append(" !");
		if (input.contains(",")) {
			phrase.append(". AND ");
			return phrase.append(maj.toString());
		}
		return maj;
	}
	
	
	// Ajoute "and" avant le dernier nom s'il y a plus de deux noms
	private static void ajoutAnd(StringBuilder phrase, String and) {
		String[] separator = phrase.toString().split("(?<=,)");
		
		if(separator.length > 2) {
			StringBuilder penultiemeTerme = new StringBuilder(separator[separator.length-2]);
			int taille = penultiemeTerme.length();
			
			penultiemeTerme.delete(taille-1, taille);
			penultiemeTerme.append(" ");
			penultiemeTerme.append(and);
			separator[separator.length-2]=penultiemeTerme.toString();
			phrase.setLength(0);
			
			for(int i = 0; i < separator.length; i++) {
				phrase.append(separator[i]);	
			}
		}
	}
	
	private static boolean GestionPrenoms(String[] noms, StringBuilder phrase, StringBuilder maj) {
	    boolean contientMaj = false;
	    for (String nom : noms) {
	        String SansEspace = nom.trim();
	        if (SansEspace.toUpperCase().equals(SansEspace)) {
	        	AddPrenom(maj, SansEspace);
	            contientMaj = true; //au moins un prenom en majuscule
	        } else {
	        	AddPrenom(phrase, SansEspace);
	        }
	    }
	    GestionVirgule(maj);
	    GestionVirgule(phrase);
	    ajoutAnd(maj, "AND");
	    ajoutAnd(phrase, "and");
	    return contientMaj;
	}
	
	private static void AddPrenom(StringBuilder phrase, String nom) {
	    nom = Capitalisation(nom);

	    StringBuilder builder = new StringBuilder(" ");
	    
	    builder.append(nom);
	    // verifier si le prenom est déja présent dans la liste
	    int index = phrase.indexOf(builder.toString());
	    if(index != -1) {
	        GestionApparrence(phrase, builder, index);
	    }
	    // si le prenom n'est pas présent, on l'ajoute
	    else {
	        phrase.append(nom);
	        phrase.append(", ");
	    }
	}
	
	//ici on met la premiere lettre en majuscule 
	private static String Capitalisation(String nom) {
	    StringBuilder maj = new StringBuilder(nom);
	    maj.setCharAt(0, Character.toUpperCase(maj.charAt(0)));
	    return maj.toString();
	}
	
	/**
	 * Gère l'apparence d'un mot déjà présent dans la phrase en ajoutant le nombre d'occurrences entre parenthèses.
	 * 
	 * @param phrase la phrase dans laquelle on recherche le mot
	 * @param builder le mot recherché
	 * @param index l'index à partir duquel on recherche le mot
	 */

	private static void GestionApparrence(StringBuilder phrase, StringBuilder builder, int index) {
		// On cherche l'index de la fin du mot, soit la prochaine virgule ou la fin de la phrase
	    int fin = phrase.indexOf(",", index + 1);
	    if (fin == -1) {
	        fin = phrase.length();
	    }
	    String occurence = phrase.substring(index + builder.length());
	    
	    if (occurence.startsWith("(x")) {
	        int xIndex = occurence.indexOf("x");
	        int occurenceInt = Integer.parseInt(occurence.substring(xIndex + 1, occurence.indexOf(")", xIndex)));
	        occurence = "(x" + (occurenceInt + 1) + ")";
	    } else {
	        occurence = "(x2)";
	    }
	    phrase.replace(index + builder.length(), fin, occurence);
	}
	
}
