import java.util.Scanner;

public class DiagonalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("taille du tableau carré (nombre de lignes/colonnes) : ");
        int size = scanner.nextInt();

        int[][] tab = new int[size][size];

        System.out.println("\nvaleurs du tableau :");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("Valeur [" + i + "][" + j + "] : ");
                tab[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\ntableau :");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(tab[i][j] + "\t");
            }
            System.out.println();
        }

        int sommeDiagonale = 0;
        for (int i = 0; i < size; i++) {
            sommeDiagonale += tab[i][i];
        }

        System.out.println("\nLa somme des éléments de la diagonale principale est : " + sommeDiagonale);

        scanner.close();
    }
}
