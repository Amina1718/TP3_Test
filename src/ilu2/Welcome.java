package ilu2;

public class Welcome {
	public static String welcome(String input) {
	    if (input == null || input.trim().isEmpty()) {
	        return "Hello, my friend";
	    }

	    StringBuilder phrase = new StringBuilder("Hello,");
	    StringBuilder majuscule = new StringBuilder();
	    String[] noms = input.split(","); // Séparer les noms en utilisant la virgule comme séparateur
	    int length = noms.length;

	    for (int i = 0; i < length; i++) {
	        String nom = noms[i].trim();
	        if (nom.toUpperCase().equals(nom)) { // Vérifier si le nom est en majuscule
	            if (majuscule.length() > 0) { //ajouter une virgule si nécessaire et ajouter le nom en majuscule au StringBuilder
	                majuscule.append(",");
	            }
	            majuscule.append(" " + nom);
	        } else {
	            nom = nom.substring(0, 1).toUpperCase() + nom.substring(1);
	            phrase.append(" " + nom + ",");
	        }
	    }
	    
	    phrase.deleteCharAt(phrase.length() - 1); // Supprimer la dernière virgule de la phrase d'accueil

	    if (majuscule.length() > 0) {
	        if (phrase.length() <= 7) {
	            return "HELLO, " + majuscule.toString().trim() + " !";
	        } else {
	            phrase.append(". AND HELLO, ");
	            if (length == 2) {
	                phrase.append(" ");
	            }
	            phrase.append(majuscule.toString().trim() + " !");
	        }
	    }
	    return phrase.toString();
	}
}





