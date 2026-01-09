package td2;

public class Exo3 {
    public static void main(String[] args) {
        int[] choices = {1, 3, 5, 10};

        for (int choice : choices) {
            System.out.println("=== Choix menu : " + choice + " ===");
            switch (choice) {
                case 1:
                    System.out.println("Consulter les statistiques");
                    break;
                case 2:
                    System.out.println("Exporter les donnees");
                    break;
                case 3:
                    System.out.println("Importer un fichier");
                    break;
                case 4:
                    System.out.println("Parametres");
                    break;
                default:
                    System.out.println("Erreur : option invalide");
            }
            System.out.println();
        }
    }
}
