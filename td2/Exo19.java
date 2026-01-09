package td2;

import java.util.ArrayList;
import java.util.Scanner;

public class Exo19 {
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Integer> qty = new ArrayList<>();
    static ArrayList<Double> prices = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== GESTION DE STOCK ===");
            System.out.println("1. Ajouter un produit");
            System.out.println("2. Afficher le stock complet");
            System.out.println("3. Rechercher un produit");
            System.out.println("4. Mettre a jour la quantite");
            System.out.println("5. Valeur totale du stock");
            System.out.println("6. Produits en rupture");
            System.out.println("7. Quitter");
            System.out.print("Votre choix : ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addProduct(); break;
                case 2: displayStock(); break;
                case 3: searchProduct(); break;
                case 4: updateQty(); break;
                case 5: totalValue(); break;
                case 6: outOfStock(); break;
                case 7: System.out.println("Au revoir !"); break;
                default: System.out.println("Choix invalide");
            }
        } while (choice != 7);

        sc.close();
    }

    static void addProduct() {
        System.out.print("Nom du produit : ");
        String name = sc.nextLine();
        System.out.print("Quantite : ");
        int q = sc.nextInt();
        System.out.print("Prix unitaire : ");
        double p = sc.nextDouble();
        names.add(name);
        qty.add(q);
        prices.add(p);
        System.out.println("Produit ajoute !");
    }

    static void displayStock() {
        if (names.isEmpty()) {
            System.out.println("Stock vide");
            return;
        }
        System.out.println("ID   Nom                 Quantite  Prix unit.  Valeur");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < names.size(); i++) {
            double val = qty.get(i) * prices.get(i);
            System.out.printf("%-4d %-20s %-9d %-11.2f %.2f EUR%n",
                    i, names.get(i), qty.get(i), prices.get(i), val);
        }
    }

    static void searchProduct() {
        System.out.print("Nom a rechercher : ");
        String name = sc.nextLine();
        int idx = names.indexOf(name);
        if (idx == -1) {
            System.out.println("Produit non trouve");
        } else {
            System.out.println("Index : " + idx);
            System.out.println("Quantite : " + qty.get(idx));
            System.out.println("Prix : " + prices.get(idx) + " EUR");
        }
    }

    static void updateQty() {
        displayStock();
        System.out.print("Index du produit : ");
        int idx = sc.nextInt();
        if (idx < 0 || idx >= names.size()) {
            System.out.println("Index invalide");
            return;
        }
        System.out.print("Nouvelle quantite : ");
        int q = sc.nextInt();
        qty.set(idx, q);
        System.out.println("Quantite mise a jour !");
    }

    static void totalValue() {
        double total = 0;
        for (int i = 0; i < names.size(); i++) {
            total += qty.get(i) * prices.get(i);
        }
        System.out.println("Valeur totale du stock : " + total + " EUR");
    }

    static void outOfStock() {
        System.out.println("Produits en rupture (quantite = 0) :");
        boolean found = false;
        for (int i = 0; i < names.size(); i++) {
            if (qty.get(i) == 0) {
                System.out.println("  - " + names.get(i));
                found = true;
            }
        }
        if (!found) System.out.println("  Aucun produit en rupture");
    }
}
