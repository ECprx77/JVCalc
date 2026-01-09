package td2;

public class Exo6 {
    public static void main(String[] args) {
        int[] qty = {45, 12, 78, 5, 60, 23};

        System.out.println("Premier produit : " + qty[0]);
        System.out.println("Dernier produit : " + qty[qty.length - 1]);

        qty[3] = 50;

        System.out.println("\nTableau apres modification :");
        for (int i = 0; i < qty.length; i++) {
            System.out.println("Produit " + i + " : " + qty[i]);
        }
    }
}
