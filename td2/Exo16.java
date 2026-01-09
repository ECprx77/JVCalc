package td2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exo16 {
    public static void main(String[] args) {
        List<String> countries = new ArrayList<>(Arrays.asList("France", "Allemagne", "Italie", "Espagne"));

        String[] tab = countries.toArray(new String[0]);

        System.out.println("Tableau :");
        for (int i = 0; i < tab.length; i++) {
            System.out.println("  [" + i + "] " + tab[i]);
        }

        for (int i = 0; i < tab.length; i++) {
            if (tab[i].equals("Italie")) {
                tab[i] = "Belgique";
                break;
            }
        }

        List<String> newList = new ArrayList<>(Arrays.asList(tab));

        System.out.println("\nNouvelle liste :");
        for (String c : newList) {
            System.out.println("  - " + c);
        }
    }
}
