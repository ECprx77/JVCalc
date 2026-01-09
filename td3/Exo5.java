package td3;

class ProduitElectronique {
    String ref;
    String name;
    double price;
    int stock;
    int warranty;

    ProduitElectronique() {
        this.ref = "REF000";
        this.name = "Produit générique";
        this.price = 0.0;
        this.stock = 0;
        this.warranty = 1;
    }

    ProduitElectronique(String ref, String name, double price, int stock, int warranty) {
        this.ref = ref;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.warranty = warranty;
    }

    ProduitElectronique(String ref, String name, double price) {
        this.ref = ref;
        this.name = name;
        this.price = price;
        this.stock = 10;
        this.warranty = 2;
    }

    ProduitElectronique(ProduitElectronique other) {
        this.ref = other.ref;
        this.name = other.name;
        this.price = other.price;
        this.stock = other.stock;
        this.warranty = other.warranty;
    }

    void afficherInfos() {
        System.out.println("Ref: " + ref + " | Nom: " + name + " | Prix: " + price + "€ | Stock: " + stock + " | Garantie: " + warranty + " ans");
    }
}

public class Exo5 {
    public static void main(String[] args) {
        ProduitElectronique p1 = new ProduitElectronique();
        ProduitElectronique p2 = new ProduitElectronique("REF001", "Smartphone Galaxy S25", 899.99, 50, 3);
        ProduitElectronique p3 = new ProduitElectronique("REF002", "Casque Bluetooth", 79.99);

        System.out.println("Produit 1 (défaut) :");
        p1.afficherInfos();
        System.out.println("\nProduit 2 (complet) :");
        p2.afficherInfos();
        System.out.println("\nProduit 3 (partiel) :");
        p3.afficherInfos();

        ProduitElectronique p4 = new ProduitElectronique(p2);
        p4.stock = 25;
        System.out.println("\nProduit 2 original après copie :");
        p2.afficherInfos();
        System.out.println("Produit 4 (copie modifiée) :");
        p4.afficherInfos();
    }
}
