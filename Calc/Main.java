import javax.swing.*;

/**
 * Point d'entrée de l'application
 * Crée le modèle et la vue, puis lance l'application
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            // Création du modèle
            Calculatrice modele = new Calculatrice();
            
            // Création de la vue (qui utilise le modèle)
            CalculatriceVue vue = new CalculatriceVue(modele);
            
            // Affichage
            vue.setVisible(true);
        });
    }
}
