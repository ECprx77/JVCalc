package td1;

public class Exo7 {
    public static void main(String[] args) {
        double priceHT = 100.0;
        double vatRate = 0.20;

        double vatAmount = priceHT * vatRate;
        double priceTTC = priceHT + vatAmount;

        System.out.println("Prix HT : " + priceHT);
        System.out.println("Taux TVA : " + (vatRate * 100) + "%");
        System.out.println("Montant TVA : " + vatAmount);
        System.out.println("Prix TTC : " + priceTTC);
    }
}
