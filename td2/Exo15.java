package td2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exo15 {
    public static void main(String[] args) {
        List<String> clients = new ArrayList<>(Arrays.asList("Dupont", "Martin", "Bernard", "Dubois", "Lefebvre"));

        Collections.sort(clients);
        System.out.println("Tri croissant (A->Z) :");
        for (String c : clients) {
            System.out.println("  " + c);
        }

        Collections.reverse(clients);
        System.out.println("\nTri decroissant (Z->A) :");
        for (String c : clients) {
            System.out.println("  " + c);
        }
    }
}
