package td2;

import java.util.ArrayList;
import java.util.Arrays;

public class Exo14 {
    public static void main(String[] args) {
        ArrayList<String> tasksTeam1 = new ArrayList<>(Arrays.asList("Tache1", "Tache2", "Tache3"));
        ArrayList<String> tasksTeam2 = new ArrayList<>(Arrays.asList("Tache4", "Tache5"));

        ArrayList<String> globalTasks = new ArrayList<>();

        globalTasks.addAll(tasksTeam1);
        globalTasks.addAll(tasksTeam2);

        System.out.println("Taches globales :");
        for (String t : globalTasks) {
            System.out.println("  - " + t);
        }

        System.out.println("\nNombre total de taches : " + globalTasks.size());
        System.out.println("\"Tache3\" presente : " + globalTasks.contains("Tache3"));
    }
}
