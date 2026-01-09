package td2;

public class Exo10 {
    public static void main(String[] args) {
        int[] pollution = {45, 120, 78, 95, 150, 60, 200, 88, 110};

        int good = 0, medium = 0, bad = 0;
        int badCount = 0;
        double total = 0;

        for (int p : pollution) {
            total += p;
            if (p < 50) good++;
            else if (p <= 100) medium++;
            else {
                bad++;
                badCount++;
            }
        }

        int[] badIndices = new int[badCount];
        int idx = 0;
        for (int p : pollution) {
            if (p > 100) badIndices[idx++] = p;
        }

        System.out.println("Categorie Bon (< 50) : " + good + " indices");
        System.out.println("Categorie Moyen (50-100) : " + medium + " indices");
        System.out.println("Categorie Mauvais (> 100) : " + bad + " indices");

        System.out.print("\nIndices > 100 : [");
        for (int i = 0; i < badIndices.length; i++) {
            System.out.print(badIndices[i]);
            if (i < badIndices.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        System.out.println("\nIndice moyen de pollution : " + (total / pollution.length));
    }
}
