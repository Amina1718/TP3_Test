package ilu2;

public class Welcome {
    public static String welcome(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Hello, my friend";
        }
        String[] noms = input.split(",");
        if (noms.length == 1) {
            String nom = noms[0].trim();
            if (nom.toUpperCase().equals(nom)) {
                return "HELLO, " + nom + " !";
            } else {
                nom = nom.substring(0, 1).toUpperCase() + nom.substring(1);
                return "Hello, " + nom;
            }
        } else if (noms.length == 2) {
            String nom1 = noms[0].trim().substring(0, 1).toUpperCase() + noms[0].trim().substring(1);
            String nom2 = noms[1].trim().substring(0, 1).toUpperCase() + noms[1].trim().substring(1);
            return "Hello, " + nom1 + ", " + nom2;
        } else {
        	// renvoie un message derreur si le nombre de noms est superieur a 2
            return "vous avez rentrez plus que deux noms!";
        }
    }
}
