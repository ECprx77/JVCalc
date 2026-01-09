package td2;

import java.util.ArrayList;
import java.util.Scanner;

public class Exo18 {
    static ArrayList<Double> grades = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== GESTION DES NOTES ===");
            System.out.println("1. Ajouter une note");
            System.out.println("2. Supprimer une note");
            System.out.println("3. Afficher toutes les notes");
            System.out.println("4. Calculer la moyenne");
            System.out.println("5. Afficher notes > moyenne");
            System.out.println("6. Quitter");
            System.out.print("Votre choix : ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addGrade();
                    break;
                case 2:
                    removeGrade();
                    break;
                case 3:
                    displayGrades();
                    break;
                case 4:
                    calcAvg();
                    break;
                case 5:
                    aboveAvg();
                    break;
                case 6:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        } while (choice != 6);

        sc.close();
    }

    static void addGrade() {
        System.out.print("Entrez la note : ");
        double g = sc.nextDouble();
        grades.add(g);
        System.out.println("Note ajoutee !");
    }

    static void removeGrade() {
        if (grades.isEmpty()) {
            System.out.println("Aucune note a supprimer");
            return;
        }
        displayGrades();
        System.out.print("Index a supprimer : ");
        int idx = sc.nextInt();
        if (idx >= 0 && idx < grades.size()) {
            grades.remove(idx);
            System.out.println("Note supprimee !");
        } else {
            System.out.println("Index invalide");
        }
    }

    static void displayGrades() {
        if (grades.isEmpty()) {
            System.out.println("Aucune note");
            return;
        }
        System.out.println("Notes :");
        for (int i = 0; i < grades.size(); i++) {
            System.out.println("  [" + i + "] " + grades.get(i));
        }
    }

    static void calcAvg() {
        if (grades.isEmpty()) {
            System.out.println("Aucune note");
            return;
        }
        double sum = 0;
        for (double g : grades) sum += g;
        System.out.println("Moyenne : " + (sum / grades.size()));
    }

    static void aboveAvg() {
        if (grades.isEmpty()) {
            System.out.println("Aucune note");
            return;
        }
        double sum = 0;
        for (double g : grades) sum += g;
        double avg = sum / grades.size();
        System.out.println("Notes > " + avg + " :");
        for (double g : grades) {
            if (g > avg) System.out.println("  " + g);
        }
    }
}
