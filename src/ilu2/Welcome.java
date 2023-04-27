package ilu2;

class Welcome {
    public static String welcome(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Hello, my friend";
        }
        String[] noms = input.split(",");
        int length = noms.length;
        if (length == 1) {
            String name = noms[0].trim();
            if (name.toUpperCase().equals(name)) {
                return "HELLO, " + name + " !";
            } else {
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                return "Hello, " + name;
            }
        } else {
            StringBuilder message = new StringBuilder("Hello,");
            for (int i = 0; i < length; i++) {
                String name = noms[i].trim();
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                message.append(" ");
                message.append(name);
                if (i != length - 1) {
                    message.append(",");
                }
            }
            return message.toString();
        }
    }
}
