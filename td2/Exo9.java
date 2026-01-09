package td2;

public class Exo9 {
    public static void main(String[] args) {
        double[] grades = {12.5, 8.0, 15.5, 10.0, 14.0, 6.5, 18.0, 11.5};

        System.out.println("Notes :");
        double total = 0;
        double best = grades[0];
        double worst = grades[0];
        int passed = 0;
        int failed = 0;

        for (double g : grades) {
            System.out.println("  " + g);
            total += g;
            if (g > best) best = g;
            if (g < worst) worst = g;
            if (g >= 10) passed++;
            else failed++;
        }

        double avg = total / grades.length;
        double successRate = (passed * 100.0) / grades.length;

        System.out.println("\nMoyenne de la classe : " + avg);
        System.out.println("Nombre d'admis : " + passed);
        System.out.println("Nombre de non-admis : " + failed);
        System.out.println("Meilleure note : " + best);
        System.out.println("Plus mauvaise note : " + worst);
        System.out.println("Taux de reussite : " + successRate + "%");
    }
}
