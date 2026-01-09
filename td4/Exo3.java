abstract class MoyenPaiement {
    protected String holder;
    protected double balance;

    MoyenPaiement(String holder, double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    abstract boolean payer(double amount);
    abstract String getTypePaiement();

    void afficherSolde() {
        System.out.println("Solde actuel: " + balance + "€");
    }

    boolean verifierSolde(double amount) {
        return balance >= amount;
    }

    void effectuerTransaction(double amount) {
        System.out.println("Transaction de " + amount + "€");
        payer(amount);
    }

    void effectuerTransaction(double amount, String desc) {
        System.out.println("Transaction de " + amount + "€ - " + desc);
        payer(amount);
    }

    void effectuerTransaction(double amount, String desc, double commission) {
        double total = amount + commission;
        System.out.println("Transaction de " + amount + "€ + commission " + commission + "€ - " + desc);
        payer(total);
    }
}

class CarteBancaire extends MoyenPaiement {
    private String cardNumber;

    CarteBancaire(String holder, double balance, String cardNumber) {
        super(holder, balance);
        this.cardNumber = cardNumber;
    }

    String getLastDigits() {
        return "****" + cardNumber.substring(cardNumber.length() - 4);
    }

    boolean payer(double amount) {
        if (verifierSolde(amount)) {
            balance -= amount;
            System.out.println(" Paiement CB " + getLastDigits() + " de " + amount + "€ accepté");
            return true;
        }
        System.out.println(" Paiement refusé: solde insuffisant");
        return false;
    }

    String getTypePaiement() { return "Carte Bancaire"; }
}

class PayPal extends MoyenPaiement {
    private String email;

    PayPal(String holder, double balance, String email) {
        super(holder, balance);
        this.email = email;
    }

    boolean payer(double amount) {
        double commission = amount * 0.02;
        double total = amount + commission;
        if (verifierSolde(total)) {
            balance -= total;
            System.out.println("Paiement PayPal (" + email + ") de " + amount + "€ + " + commission + "€ commission");
            return true;
        }
        System.out.println("Paiement PayPal refusé: solde insuffisant (montant + 2% commission)");
        return false;
    }

    String getTypePaiement() { return "PayPal"; }
}

class Crypto extends MoyenPaiement {
    private String wallet;

    Crypto(String holder, double balance, String wallet) {
        super(holder, balance);
        this.wallet = wallet;
    }

    boolean payer(double amount) {
        double commission = amount * 0.01;
        double total = amount + commission;
        if (verifierSolde(total)) {
            balance -= total;
            System.out.println("Transaction blockchain en cours...");
            System.out.println("Paiement Crypto (" + wallet.substring(0, 8) + "...) de " + amount + "€ + " + commission + "€ frais réseau");
            return true;
        }
        System.out.println("Paiement Crypto refusé: solde insuffisant");
        return false;
    }

    String getTypePaiement() { return "Cryptomonnaie"; }
}

public class Exo3 {
    public static void main(String[] args) {
        MoyenPaiement[] moyens = {
            new CarteBancaire("Alice Martin", 1500.00, "4532015112830366"),
            new PayPal("Bob Dupont", 800.00, "bob.dupont@mail.com"),
            new Crypto("Charlie Leroy", 2000.00, "0x742d35Cc6634C0532925a3b844Bc9e7595f")
        };

        for (MoyenPaiement mp : moyens) {
            System.out.println("\n========== " + mp.getTypePaiement() + " ==========");
            System.out.println("Titulaire: " + mp.holder);
            mp.afficherSolde();

            System.out.println("\n--- Paiement simple ---");
            mp.effectuerTransaction(50.00);

            System.out.println("\n--- Paiement avec description ---");
            mp.effectuerTransaction(75.00, "Achat Amazon");

            System.out.println("\n--- Paiement avec commission ---");
            mp.effectuerTransaction(100.00, "Achat premium", 5.00);

            System.out.println("\n--- Solde final ---");
            mp.afficherSolde();
        }
    }
}
