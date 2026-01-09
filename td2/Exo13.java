package td2;

import java.util.ArrayList;

public class Exo13 {
    public static void main(String[] args) {
        ArrayList<String> queue = new ArrayList<>();

        queue.add("Client_A");
        queue.add("Client_B");
        queue.add("Client_C");
        queue.add("Client_D");
        queue.add("Client_E");

        System.out.println("File d'attente initiale :");
        for (String c : queue) {
            System.out.println("  " + c);
        }

        String treated = queue.remove(0);
        System.out.println("\nClient traite : " + treated);

        System.out.println("\nFile apres traitement :");
        for (String c : queue) {
            System.out.println("  " + c);
        }

        queue.add("Client_F");

        System.out.println("\nPosition de Client_D : " + queue.indexOf("Client_D"));
        System.out.println("Nombre total de clients en attente : " + queue.size());

        System.out.println("\nFile actuelle :");
        for (String c : queue) {
            System.out.println("  " + c);
        }
    }
}
