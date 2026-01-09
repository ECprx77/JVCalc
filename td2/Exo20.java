package td2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Exo20 {
    public static void main(String[] args) {
        ArrayList<Double> sales = new ArrayList<>(Arrays.asList(
            150.0, 200.0, 120.0, 300.0, 180.0, 220.0, 250.0,
            190.0, 280.0, 210.0, 160.0, 290.0, 230.0, 270.0
        ));

        double total = 0;
        double maxSale = sales.get(0);
        double minSale = sales.get(0);
        int maxDay = 1, minDay = 1;

        for (int i = 0; i < sales.size(); i++) {
            double s = sales.get(i);
            total += s;
            if (s > maxSale) { maxSale = s; maxDay = i + 1; }
            if (s < minSale) { minSale = s; minDay = i + 1; }
        }

        double avg = total / sales.size();

        int aboveAvg = 0;
        for (double s : sales) {
            if (s > avg) aboveAvg++;
        }
        double aboveAvgPct = (aboveAvg * 100.0) / sales.size();

        double target = 250.0;
        int targetReached = 0;
        for (double s : sales) {
            if (s >= target) targetReached++;
        }
        double targetPct = (targetReached * 100.0) / sales.size();

        ArrayList<Double> sorted = new ArrayList<>(sales);
        Collections.sort(sorted, Collections.reverseOrder());

        int range1 = 0, range2 = 0, range3 = 0, range4 = 0;
        for (double s : sales) {
            if (s <= 150) range1++;
            else if (s <= 200) range2++;
            else if (s <= 250) range3++;
            else range4++;
        }

        System.out.println("=== ANALYSE DES VENTES ===");
        System.out.printf("Vente totale : %.1f EUR%n", total);
        System.out.printf("Vente moyenne : %.2f EUR%n", avg);
        System.out.printf("Meilleure vente : %.1f EUR (jour %d)%n", maxSale, maxDay);
        System.out.printf("Pire vente : %.1f EUR (jour %d)%n", minSale, minDay);
        System.out.println();
        System.out.printf("Jours > moyenne : %d (%.2f%%)%n", aboveAvg, aboveAvgPct);
        System.out.printf("Objectif atteint : %d jours (%.2f%%)%n", targetReached, targetPct);
        System.out.println();
        System.out.printf("Top 3 des ventes : %.1f EUR, %.1f EUR, %.1f EUR%n",
                sorted.get(0), sorted.get(1), sorted.get(2));
        System.out.println();
        System.out.println("Repartition :");
        System.out.println("  0-150 EUR : " + range1 + " jours");
        System.out.println("  151-200 EUR : " + range2 + " jours");
        System.out.println("  201-250 EUR : " + range3 + " jours");
        System.out.println("  >250 EUR : " + range4 + " jours");
    }
}
