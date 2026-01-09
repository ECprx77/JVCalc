package td2;

public class Exo5 {
    public static void main(String[] args) {
        String[] codes = {"AL", "EL", "XX"};

        for (String code : codes) {
            System.out.println("=== Code produit : " + code + " ===");
            String category;
            double vatRate;

            switch (code) {
                case "AL":
                    category = "Alimentation";
                    vatRate = 5.5;
                    break;
                case "EL":
                    category = "Electronique";
                    vatRate = 20.0;
                    break;
                case "VT":
                    category = "Vetements";
                    vatRate = 20.0;
                    break;
                case "MB":
                    category = "Meubles";
                    vatRate = 20.0;
                    break;
                case "LV":
                    category = "Livres";
                    vatRate = 5.5;
                    break;
                default:
                    category = "Categorie inconnue";
                    vatRate = 0.0;
            }

            System.out.println("Categorie : " + category);
            System.out.println("Taux TVA : " + vatRate + "%\n");
        }
    }
}
