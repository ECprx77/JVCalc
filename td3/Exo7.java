package td3;

class Abonnement {
    private String id;
    private String email;
    private String plan;
    private double monthlyPrice;
    private boolean active;

    Abonnement(String id, String email, String plan, double monthlyPrice, boolean active) {
        this.id = id;
        this.email = email;
        this.plan = plan;
        this.monthlyPrice = monthlyPrice;
        this.active = active;
    }

    String getId() { return id; }
    String getEmail() { return email; }
    String getPlan() { return plan; }
    double getMonthlyPrice() { return monthlyPrice; }
    boolean isActive() { return active; }

    void setEmail(String email) {
        if (email.contains("@") && email.contains(".")) {
            this.email = email;
            System.out.println("Email modifié");
        } else {
            System.out.println("Erreur : email invalide");
        }
    }

    void setPlan(String plan) {
        if (plan.equals("Basic") || plan.equals("Standard") || plan.equals("Premium")) {
            this.plan = plan;
            if (plan.equals("Basic")) this.monthlyPrice = 9.99;
            else if (plan.equals("Standard")) this.monthlyPrice = 14.99;
            else this.monthlyPrice = 19.99;
            System.out.println("Formule changée en " + plan + " - Nouveau prix : " + monthlyPrice + "€");
        } else {
            System.out.println("Erreur : formule invalide (Basic, Standard ou Premium uniquement)");
        }
    }

    void setActive(boolean active) {
        this.active = active;
    }

    void afficherDetails() {
        System.out.println("ID: " + id + " | Email: " + email + " | Formule: " + plan + " | Prix: " + monthlyPrice + "€/mois | Actif: " + active);
    }

    double calculerCoutAnnuel() {
        return active ? monthlyPrice * 12 : 0;
    }
}

public class Exo7 {
    public static void main(String[] args) {
        Abonnement a1 = new Abonnement("AB001", "alice@mail.com", "Basic", 9.99, true);
        Abonnement a2 = new Abonnement("AB002", "bob@mail.com", "Standard", 14.99, true);
        Abonnement a3 = new Abonnement("AB003", "charlie@mail.com", "Premium", 19.99, true);

        System.out.println("Détails des abonnements :");
        a1.afficherDetails();
        a2.afficherDetails();
        a3.afficherDetails();

        System.out.println("\nDésactivation de l'abonnement 2 :");
        a2.setActive(false);

        System.out.println("\nTentative de changement en VIP :");
        a1.setPlan("VIP");

        System.out.println("\nChangement en Premium :");
        a1.setPlan("Premium");

        double totalAnnuel = a1.calculerCoutAnnuel() + a2.calculerCoutAnnuel() + a3.calculerCoutAnnuel();
        System.out.println("\nCoût annuel total des abonnements actifs : " + totalAnnuel + "€");
    }
}
