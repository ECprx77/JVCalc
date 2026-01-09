package td2;

public class Exo2 {
    public static void main(String[] args) {
        double[] amounts = {50.0, 150.0, 350.0, 600.0};

        for (double cart : amounts) {
            System.out.println("=== Panier : " + cart + " EUR ===");
            double rate = 0;

            if (cart >= 500) {
                rate = 0.20;
            } else if (cart >= 300) {
                rate = 0.15;
            } else if (cart >= 100) {
                rate = 0.10;
            }

            double discount = cart * rate;
            double finalAmount = cart - discount;

            if (rate > 0) {
                System.out.println("Remise appliquee : " + (int)(rate * 100) + "%");
            } else {
                System.out.println("Aucune remise");
            }
            System.out.println("Montant final : " + finalAmount + " EUR\n");
        }
    }
}
