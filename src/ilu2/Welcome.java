package ilu2;


public class Welcome {
	public static String welcome(String input) {
	    // Vérifier si l'entrée est vide ou null
	    if (input == null || input.trim().isEmpty()) {
	        return "Hello, my friend";
	    }

	    // Initialiser la phrase avec "Hello, "
	    StringBuilder phrase = new StringBuilder("Hello, ");
	    
	    // Séparer les noms
	    String[] noms = input.split(",");
	    
	    StringBuilder majuscule = new StringBuilder(phrase.toString().toUpperCase());

	    GestionPrenoms(noms, phrase, majuscule);
		
		// Gérer les cas où Yoda est présent
		GestionYoda(phrase);
		GestionYoda(majuscule);
		
		// Gérer les virgules
		GestionVirgule(majuscule);
		GestionVirgule(phrase);
		
		// Ajouter "AND" ou "and" selon la phrase
		ajoutAnd(majuscule, "AND");
		ajoutAnd(phrase, "and");
		
		// Vérifier si la phrase est vide
		if(phrase.length() < 8) {
			phrase.setLength(0);
		}
		
		// Ajouter la gestion des cris
		phrase.append(GestionCrie(phrase, majuscule,input));
		
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
	
	
	private static StringBuilder GestionCrie(StringBuilder message, StringBuilder messageUpperCase, String input) {
	    if (messageUpperCase.length() >= 8) {
	        messageUpperCase.append(" !");
	        // Si l'input contient une virgule et que le message est non vide
	        if (input.contains(",") && message.length() > 0) {
	            messageUpperCase.insert(0, ". AND ");
	        }
	    }
	    // Retourne un StringBuilder vide si la longueur du message en majuscules est inférieure à 8, sinon retourne le message en majuscules
	    return messageUpperCase.length() < 8 ? new StringBuilder() : messageUpperCase;
	}

	
	
	public static void GestionAnd(StringBuilder penultiemeTerme, String and) {
	    // Récupération de l'index de la dernière virgule dans la chaîne de caractères penultiemeTerme
	    int lastCommaIndex = penultiemeTerme.lastIndexOf(",");
	    if (lastCommaIndex >= 0) {
	        // Remplacement de la dernière virgule par and
	        penultiemeTerme.replace(lastCommaIndex, lastCommaIndex + 1, " " + and);
	    }
	}

	private static void ajoutAnd(StringBuilder phrase, String and) {
	    String[] separator = phrase.toString().split("(?<=,)");
	    if (separator.length <= 2) {
	        return;
	    }
	    int index = separator.length - 2;
	    if (separator[separator.length-1].toUpperCase().equals(" HELLO")) {
	        index--;
	    }
	    StringBuilder penultiemeTerme = new StringBuilder(separator[index]);
	    
	    // Ajout de l'élément and à la fin de la sous-chaîne penultiemeTerme
	    GestionAnd(penultiemeTerme, and);
	    separator[index] = penultiemeTerme.toString();

	    // Construction de la chaîne de caractères phrase à partir du tableau separator mis à jour
	    phrase.setLength(0);
	    for (String s : separator) {
	        phrase.append(s);
	    }
	}

	private static boolean GestionPrenoms(String[] noms, StringBuilder phrase, StringBuilder maj) {
	    boolean contientMaj = false;
	    for (String nom : noms) {
	        String SansEspace = nom.trim();
	        if (SansEspace.toUpperCase().equals(SansEspace)) {
	            // Si le nom est en majuscules, on l'ajoute à la variable maj
	            AddPrenom(maj, SansEspace);
	            contientMaj = true; //au moins un prenom en majuscule
	        } else {
	            // Sinon, on l'ajoute à la variable phrase
	            AddPrenom(phrase, SansEspace);
	        }
	    }
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
	    // sinon on l'ajoute
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
	
	//ok
	private static void GestionApparrence(StringBuilder phrase, StringBuilder builder, int index) {
		// On cherche l'index de la fin du mot, soit la prochaine virgule ou la fin de la phrase
	    int fin = phrase.indexOf(",", index + 1);
	    if (fin == -1) {
	        fin = phrase.length();
	    }
	    String occurence = phrase.substring(index + builder.length());
	    
	    if (occurence.startsWith(" (x")) {
	        int xIndex = occurence.indexOf("x");
	        int occurenceInt = Integer.parseInt(occurence.substring(xIndex + 1, occurence.indexOf(")", xIndex)));
	        occurence = " (x" + (occurenceInt + 1) + ")";
	    } else {
	        occurence = " (x2)";
	    }
	    phrase.replace(index + builder.length(), fin, occurence);
	}
	
	
	private static void GestionYoda(StringBuilder phrase) {
	    String messageUpper = phrase.toString().toUpperCase();
	    
	    // Rechercher l'index de la première occurrence de " YODA"
	    int yodaIndex = messageUpper.indexOf(" YODA");
	    
	    // Vérifier si " YODA" a été trouvé
	    if (yodaIndex != -1) {
	        // Calculer l'index de la fin de " YODA"
	        int yodaEndIndex = yodaIndex + 5;
	        
	        // Vérifier si la fin de " YODA" est suivie par une virgule, une parenthèse ou un espace
	        if (messageUpper.charAt(yodaEndIndex) == ',' || messageUpper.charAt(yodaEndIndex) == '(' 
	                || messageUpper.charAt(yodaEndIndex) == ' ') {
	            // Si c'est le cas, inverser l'ordre des mots dans la phrase
	            String[] elements = phrase.toString().split(" ");
	            String firstWord = elements[0];
	            StringBuilder restOfMessage = new StringBuilder();
	            for (int i = 1; i < elements.length; i++) {
	                restOfMessage.append(elements[i]).append(" ");
	            }
	            phrase.setLength(0);
	            phrase.append(restOfMessage.toString().trim()).append(" ").append(firstWord);
	        }
	    }
	}

}
