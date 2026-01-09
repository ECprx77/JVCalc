abstract class Equipement {
    protected String ref;
    protected String location;
    protected boolean inService;

    Equipement(String ref, String location, boolean inService) {
        this.ref = ref;
        this.location = location;
        this.inService = inService;
    }

    abstract void effectuerMaintenance();

    void afficherEtat() {
        System.out.println("Ref: " + ref + " | Emplacement: " + location + " | En service: " + inService);
    }
}

class Ordinateur extends Equipement {
    String os;

    Ordinateur(String ref, String location, boolean inService, String os) {
        super(ref, location, inService);
        this.os = os;
    }

    void redemarrer() {
        System.out.println("Redémarrage de l'ordinateur " + ref + "...");
    }

    void effectuerMaintenance() {
        System.out.println("Maintenance PC: Nettoyage disque, MAJ système, scan antivirus");
    }
}

class Imprimante extends Equipement {
    int inkLevel;

    Imprimante(String ref, String location, boolean inService, int inkLevel) {
        super(ref, location, inService);
        this.inkLevel = inkLevel;
    }

    void remplacerCartouche() {
        inkLevel = 100;
        System.out.println("🖨 Cartouche remplacée - Niveau encre: 100%");
    }

    void effectuerMaintenance() {
        System.out.println("Maintenance imprimante: Nettoyage têtes, alignement, test impression");
    }
}

class Serveur extends Equipement {
    int cpuCount;

    Serveur(String ref, String location, boolean inService, int cpuCount) {
        super(ref, location, inService);
        this.cpuCount = cpuCount;
    }

    void sauvegarder() {
        System.out.println("Sauvegarde serveur " + ref + " en cours...");
    }

    void effectuerMaintenance() {
        System.out.println("Maintenance serveur: Vérif RAID, logs, température, mise à jour sécurité");
    }
}

class GestionParc {
    static void diagnostiquerEquipement(Equipement eq) {
        System.out.println("\n============================");
        eq.afficherEtat();
        eq.effectuerMaintenance();

        if (eq instanceof Ordinateur) {
            Ordinateur pc = (Ordinateur) eq;
            System.out.println("💻 OS: " + pc.os);
            pc.redemarrer();
        } else if (eq instanceof Imprimante) {
            Imprimante imp = (Imprimante) eq;
            System.out.println("🖨 Niveau encre: " + imp.inkLevel + "%");
            if (imp.inkLevel < 20) {
                imp.remplacerCartouche();
            }
        } else if (eq instanceof Serveur) {
            Serveur srv = (Serveur) eq;
            System.out.println("🖥 Nombre CPUs: " + srv.cpuCount);
            srv.sauvegarder();
        }
    }
}

public class Exo4 {
    public static void main(String[] args) {
        Equipement[] parc = {
            new Ordinateur("PC-001", "Bureau 101", true, "Windows 11"),
            new Ordinateur("PC-002", "Bureau 205", true, "Ubuntu 22.04"),
            new Imprimante("IMP-001", "Couloir 1er", true, 75),
            new Imprimante("IMP-002", "Accueil", false, 12),
            new Serveur("SRV-001", "Salle serveur", true, 32)
        };

        int pcCount = 0, impCount = 0, srvCount = 0;

        for (Equipement eq : parc) {
            GestionParc.diagnostiquerEquipement(eq);
            if (eq instanceof Ordinateur) pcCount++;
            else if (eq instanceof Imprimante) impCount++;
            else if (eq instanceof Serveur) srvCount++;
        }

        System.out.println("\n========== STATISTIQUES ==========");
        System.out.println("Ordinateurs: " + pcCount);
        System.out.println("Imprimantes: " + impCount);
        System.out.println("Serveurs: " + srvCount);
        System.out.println("Total équipements: " + parc.length);
    }
}
