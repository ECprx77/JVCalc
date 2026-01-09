package td2;

import java.util.ArrayList;

public class Exo12 {
    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();

        scores.add(1200);
        scores.add(950);
        scores.add(1450);
        scores.add(800);
        scores.add(1600);

        System.out.println("Score 950 existe : " + scores.contains(950));
        System.out.println("Index de 1450 : " + scores.indexOf(1450));

        int idx = scores.indexOf(800);
        scores.set(idx, 1000);

        System.out.println("\nListe mise a jour :");
        for (int s : scores) {
            System.out.println("  " + s);
        }

        System.out.println("\nPremier score : " + scores.get(0));
        System.out.println("Dernier score : " + scores.get(scores.size() - 1));
    }
}
