package td3;

class CompteBancaire {
    String accountNumber;
    String holderName;
    double balance;
    String type;

    CompteBancaire() {
        this.accountNumber = "000000";
        this.holderName = "Anonyme";
        this.balance = 0.0;
        this.type = "Courant";
    }

    CompteBancaire(String accountNumber, String holderName, double balance, String type) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.type = type;
    }

    CompteBancaire(CompteBancaire other) {
        this.accountNumber = other.accountNumber;
        this.holderName = other.holderName;
        this.balance = other.balance;
        this.type = other.type;
    }

    void display() {
        System.out.println("Compte n°" + accountNumber + " - " + holderName + " - Solde: " + balance + "€ - Type: " + type);
    }
}

public class Exo4 {
    public static void main(String[] args) {
        CompteBancaire c1 = new CompteBancaire();
        System.out.println("Compte par défaut :");
        c1.display();

        CompteBancaire c2 = new CompteBancaire("FR123456", "Sophie Leblanc", 2500.00, "Épargne");
        System.out.println("\nCompte paramétré :");
        c2.display();

        CompteBancaire c3 = new CompteBancaire(c2);
        c3.holderName = "Jean Leblanc";
        System.out.println("\nCompte original après copie :");
        c2.display();
        System.out.println("Copie modifiée :");
        c3.display();
    }
}
