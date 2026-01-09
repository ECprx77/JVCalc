package td2;

public class Exo4 {
    public static void main(String[] args) {
        int[][] profiles = {{1, 3000}, {5, 2200}, {3, 3500}};
        boolean[] incidents = {false, false, true};

        for (int i = 0; i < 3; i++) {
            int seniority = profiles[i][0];
            double income = profiles[i][1];
            boolean hasIncident = incidents[i];

            System.out.println("=== Profil " + (i + 1) + " ===");
            System.out.println("Anciennete : " + seniority + " ans");
            System.out.println("Revenu : " + income + " EUR");
            System.out.println("Incidents : " + (hasIncident ? "Oui" : "Non"));

            boolean eligible = seniority >= 2 && income >= 2500 && !hasIncident;

            if (eligible) {
                System.out.println("Pret accorde - Profil valide");
            } else {
                System.out.println("Pret refuse - Criteres non satisfaits");
                if (seniority < 2) System.out.println("  -> Anciennete insuffisante");
                if (income < 2500) System.out.println("  -> Revenu insuffisant");
                if (hasIncident) System.out.println("  -> Incidents de paiement");
            }
            System.out.println();
        }
    }
}
