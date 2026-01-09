package td3;

class Vehicule {
    protected String plate;
    protected String brand;
    protected int year;

    Vehicule(String plate, String brand, int year) {
        this.plate = plate;
        this.brand = brand;
        this.year = year;
    }

    void afficherInfos() {
        System.out.println("Immatriculation: " + plate + " | Marque: " + brand + " | Année: " + year);
    }
}

class Camion extends Vehicule {
    int maxLoad;

    Camion(String plate, String brand, int year, int maxLoad) {
        super(plate, brand, year);
        this.maxLoad = maxLoad;
    }

    void afficherInfosCamion() {
        afficherInfos();
        System.out.println("Charge maximale: " + maxLoad + " kg");
    }
}

class Moto extends Vehicule {
    int displacement;

    Moto(String plate, String brand, int year, int displacement) {
        super(plate, brand, year);
        this.displacement = displacement;
    }

    void afficherInfosMoto() {
        afficherInfos();
        System.out.println("Cylindrée: " + displacement + " cm³");
    }
}

public class Exo8 {
    public static void main(String[] args) {
        Camion c1 = new Camion("AB-123-CD", "Mercedes", 2020, 18000);
        Camion c2 = new Camion("EF-456-GH", "Volvo", 2019, 24000);
        Moto m1 = new Moto("IJ-789-KL", "Yamaha", 2022, 600);
        Moto m2 = new Moto("MN-012-OP", "Kawasaki", 2021, 1000);

        System.out.println("=== Camions ===");
        c1.afficherInfosCamion();
        System.out.println();
        c2.afficherInfosCamion();

        System.out.println("\n=== Motos ===");
        m1.afficherInfosMoto();
        System.out.println();
        m2.afficherInfosMoto();
    }
}
