package td3;

class Personnel {
    protected String id;
    protected String lastName;
    protected String firstName;
    protected double baseSalary;

    Personnel(String id, String lastName, String firstName, double baseSalary) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.baseSalary = baseSalary;
    }

    double calculerSalaire() {
        return baseSalary;
    }

    void afficherFiche() {
        System.out.println("Matricule: " + id + " | Nom: " + lastName + " | Prénom: " + firstName + " | Salaire: " + calculerSalaire() + "€");
    }
}

class Commercial extends Personnel {
    double turnover;
    double commissionRate;

    Commercial(String id, String lastName, String firstName, double baseSalary, double turnover, double commissionRate) {
        super(id, lastName, firstName, baseSalary);
        this.turnover = turnover;
        this.commissionRate = commissionRate;
    }

    double calculerSalaire() {
        return baseSalary + (turnover * commissionRate);
    }

    void afficherFicheCommercial() {
        afficherFiche();
        System.out.println("CA: " + turnover + "€ | Taux commission: " + (commissionRate * 100) + "%");
    }
}

class Technicien extends Personnel {
    int overtimeHours;
    double hourlyRate;

    Technicien(String id, String lastName, String firstName, double baseSalary, int overtimeHours, double hourlyRate) {
        super(id, lastName, firstName, baseSalary);
        this.overtimeHours = overtimeHours;
        this.hourlyRate = hourlyRate;
    }

    double calculerSalaire() {
        return baseSalary + (overtimeHours * hourlyRate);
    }

    void afficherFicheTechnicien() {
        afficherFiche();
        System.out.println("Heures supp: " + overtimeHours + "h | Taux horaire: " + hourlyRate + "€");
    }
}

class Manager extends Personnel {
    double bonus;

    Manager(String id, String lastName, String firstName, double baseSalary, double bonus) {
        super(id, lastName, firstName, baseSalary);
        this.bonus = bonus;
    }

    double calculerSalaire() {
        return baseSalary + bonus;
    }

    void afficherFicheManager() {
        afficherFiche();
        System.out.println("Prime: " + bonus + "€");
    }
}

public class Exo9 {
    public static void main(String[] args) {
        Commercial com1 = new Commercial("COM001", "Durand", "Pierre", 2000, 50000, 0.05);
        Commercial com2 = new Commercial("COM002", "Bernard", "Claire", 2200, 75000, 0.06);
        Technicien tech1 = new Technicien("TECH001", "Petit", "Luc", 1800, 15, 25);
        Technicien tech2 = new Technicien("TECH002", "Robert", "Anne", 1900, 20, 22);
        Manager mgr1 = new Manager("MGR001", "Lambert", "François", 3500, 800);

        System.out.println("=== Commerciaux ===");
        com1.afficherFicheCommercial();
        System.out.println();
        com2.afficherFicheCommercial();

        System.out.println("\n=== Techniciens ===");
        tech1.afficherFicheTechnicien();
        System.out.println();
        tech2.afficherFicheTechnicien();

        System.out.println("\n=== Manager ===");
        mgr1.afficherFicheManager();

        double totalSalary = com1.calculerSalaire() + com2.calculerSalaire() + tech1.calculerSalaire() + tech2.calculerSalaire() + mgr1.calculerSalaire();
        System.out.println("\n=== Masse salariale totale : " + totalSalary + "€ ===");
    }
}
