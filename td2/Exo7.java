package td2;

public class Exo7 {
    public static void main(String[] args) {
        double[] revenue = {12500.0, 9800.0, 15200.0, 11000.0, 18500.0, 13700.0};

        System.out.println("Chiffres d'affaires mensuels :");
        double total = 0;
        for (int i = 0; i < revenue.length; i++) {
            System.out.println("Mois " + (i + 1) + " : " + revenue[i] + " EUR");
            total += revenue[i];
        }

        double avg = total / revenue.length;

        int aboveAvg = 0;
        for (double r : revenue) {
            if (r > avg) aboveAvg++;
        }

        System.out.println("\nChiffre d'affaires total : " + total + " EUR");
        System.out.println("Chiffre d'affaires moyen : " + avg + " EUR");
        System.out.println("Nombre de mois au-dessus de la moyenne : " + aboveAvg);
    }
}
