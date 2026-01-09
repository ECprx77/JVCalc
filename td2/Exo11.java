package td2;

import java.util.ArrayList;

public class Exo11 {
    public static void main(String[] args) {
        ArrayList<String> courses = new ArrayList<>();

        courses.add("Mathematiques");
        courses.add("Programmation Java");
        courses.add("Base de donnees");
        courses.add("Reseaux");
        courses.add("Systemes d'exploitation");
        courses.add("Intelligence Artificielle");

        System.out.println("Liste des cours :");
        for (String c : courses) {
            System.out.println("  - " + c);
        }

        courses.remove("Base de donnees");

        System.out.println("\nTaille apres suppression : " + courses.size());

        System.out.println("\nListe mise a jour :");
        for (String c : courses) {
            System.out.println("  - " + c);
        }

        String search = "Algorithmique";
        System.out.println("\n\"" + search + "\" existe : " + courses.contains(search));

        search = "Reseaux";
        System.out.println("\"" + search + "\" existe : " + courses.contains(search));
    }
}
