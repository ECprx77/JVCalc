package td2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Exo17 {
    public static void main(String[] args) {
        ArrayList<Double> grades = new ArrayList<>(Arrays.asList(14.5, 8.0, 16.0, 10.5, 12.0, 9.5, 18.0, 11.5));

        System.out.println("Liste avant tri :");
        for (double g : grades) {
            System.out.print(g + " ");
        }

        Collections.sort(grades);

        System.out.println("\n\nListe apres tri :");
        for (double g : grades) {
            System.out.print(g + " ");
        }

        double median;
        int n = grades.size();
        if (n % 2 == 0) {
            median = (grades.get(n / 2 - 1) + grades.get(n / 2)) / 2;
        } else {
            median = grades.get(n / 2);
        }

        System.out.println("\n\nMediane : " + median);
    }
}
