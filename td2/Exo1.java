package td2;

public class Exo1 {
    public static void main(String[] args) {
        int level = 3;

        System.out.println("=== Test niveau = " + level + " ===");
        if (level >= 2) {
            System.out.println("Inscription validee - Niveau suffisant");
        } else {
            System.out.println("Inscription refusee - Niveau insuffisant");
        }

        level = 1;
        System.out.println("\n=== Test niveau = " + level + " ===");
        if (level >= 2) {
            System.out.println("Inscription validee - Niveau suffisant");
        } else {
            System.out.println("Inscription refusee - Niveau insuffisant");
        }

        level = 4;
        System.out.println("\n=== Test niveau = " + level + " ===");
        if (level >= 2) {
            System.out.println("Inscription validee - Niveau suffisant");
        } else {
            System.out.println("Inscription refusee - Niveau insuffisant");
        }
    }
}
