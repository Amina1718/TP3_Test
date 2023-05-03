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
	
	private static void ajouterPrenomAvecMajuscule(StringBuilder message, String nom) {
	    if (nom == null || nom.isEmpty()) {
	        return;
	    }
	    message.append(nom.substring(0, 1).toUpperCase()).append(nom.substring(1)).append(", ");
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
			return phrase.append(maj.toString().toUpperCase());
		}
		return maj;
	}
	
	
	// Ajoute "and" avant le dernier nom s'il y a plus de deux noms
	private static void ajoutAnd(StringBuilder phrase) {
		String[] separator = phrase.toString().split("(?<=,)");
		
		if(separator.length > 2) {
			StringBuilder penultiemeTerme = new StringBuilder(separator[separator.length-2]);
			int taille = penultiemeTerme.length();
			
			penultiemeTerme.delete(taille-1, taille);
			penultiemeTerme.append(" and");
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
	        	ajouterPrenomAvecMajuscule(maj, SansEspace);
	            contientMaj = true; //au moins un prenom en majuscule
	        } else {
	        	ajouterPrenomAvecMajuscule(phrase, SansEspace);
	        }
	    }
	    GestionVirgule(maj);
	    GestionVirgule(phrase);
	    ajoutAnd(maj);
	    ajoutAnd(phrase);
	    return contientMaj;
	}
}
