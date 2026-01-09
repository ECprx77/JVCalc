interface Rechargeable {
    void recharger();
    int getNiveauBatterie();
    void afficherBatterie();
}

interface Portable {
    double getPoids();
    void afficherPortabilite();
}

interface Connecte {
    void connecterWifi(String reseau);
    void deconnecter();
    boolean estConnecte();
}

abstract class AppareilElectronique {
    protected String brand;
    protected String model;
    protected double price;

    AppareilElectronique(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    abstract void allumer();

    void afficherCaracteristiques() {
        System.out.println("Marque: " + brand + " | Modèle: " + model + " | Prix: " + price + "€");
    }
}

class Smartphone extends AppareilElectronique implements Rechargeable, Portable, Connecte {
    private int battery;
    private double weight;
    private boolean wifiActive;
    private String network;

    Smartphone(String brand, String model, double price, int battery, double weight) {
        super(brand, model, price);
        this.battery = battery;
        this.weight = weight;
        this.wifiActive = false;
        this.network = "";
    }

    void allumer() {
        System.out.println(brand + " " + model + " démarre... Bienvenue !");
    }

    public void recharger() {
        battery = 100;
        System.out.println("Smartphone rechargé à 100%");
    }

    public int getNiveauBatterie() { return battery; }

    public void afficherBatterie() {
        System.out.println("Batterie smartphone: " + battery + "%");
    }

    public double getPoids() { return weight; }

    public void afficherPortabilite() {
        System.out.println("Poids: " + weight + " kg - Très portable");
    }

    public void connecterWifi(String reseau) {
        this.network = reseau;
        this.wifiActive = true;
        System.out.println("Connecté au réseau: " + reseau);
    }

    public void deconnecter() {
        this.wifiActive = false;
        this.network = "";
        System.out.println("WiFi déconnecté");
    }

    public boolean estConnecte() { return wifiActive; }
}

class OrdinateurPortable extends AppareilElectronique implements Rechargeable, Portable, Connecte {
    private int battery;
    private double weight;
    private boolean wifiActive;
    private String network;

    OrdinateurPortable(String brand, String model, double price, int battery, double weight) {
        super(brand, model, price);
        this.battery = battery;
        this.weight = weight;
        this.wifiActive = false;
        this.network = "";
    }

    void allumer() {
        System.out.println(brand + " " + model + " en cours de démarrage... Chargement OS...");
    }

    public void recharger() {
        battery = 100;
        System.out.println("Ordinateur portable rechargé à 100%");
    }

    public int getNiveauBatterie() { return battery; }

    public void afficherBatterie() {
        System.out.println("Batterie laptop: " + battery + "%");
    }

    public double getPoids() { return weight; }

    public void afficherPortabilite() {
        System.out.println("Poids: " + weight + " kg - Portable avec sacoche");
    }

    public void connecterWifi(String reseau) {
        this.network = reseau;
        this.wifiActive = true;
        System.out.println("Laptop connecté à: " + reseau);
    }

    public void deconnecter() {
        this.wifiActive = false;
        this.network = "";
        System.out.println("Laptop WiFi déconnecté");
    }

    public boolean estConnecte() { return wifiActive; }
}

class Tablette extends AppareilElectronique implements Rechargeable, Portable {
    private int battery;
    private double weight;

    Tablette(String brand, String model, double price, int battery, double weight) {
        super(brand, model, price);
        this.battery = battery;
        this.weight = weight;
    }

    void allumer() {
        System.out.println(brand + " " + model + " s'allume... Écran tactile prêt !");
    }

    public void recharger() {
        battery = 100;
        System.out.println("Tablette rechargée à 100%");
    }

    public int getNiveauBatterie() { return battery; }

    public void afficherBatterie() {
        System.out.println("Batterie tablette: " + battery + "%");
    }

    public double getPoids() { return weight; }

    public void afficherPortabilite() {
        System.out.println("Poids: " + weight + " kg - Facilement transportable");
    }
}

public class Exo2 {
    static void cycleRecharge(Rechargeable appareil) {
        System.out.println("\n--- Cycle de recharge ---");
        appareil.afficherBatterie();
        appareil.recharger();
        appareil.afficherBatterie();
    }

    public static void main(String[] args) {
        Smartphone phone = new Smartphone("Apple", "iPhone 15", 1199.00, 45, 0.171);
        OrdinateurPortable laptop = new OrdinateurPortable("Dell", "XPS 15", 1899.00, 30, 1.86);
        Tablette tablet = new Tablette("Samsung", "Galaxy Tab S9", 849.00, 60, 0.498);

        System.out.println("=== SMARTPHONE ===");
        phone.afficherCaracteristiques();
        phone.allumer();
        phone.afficherBatterie();
        phone.afficherPortabilite();
        phone.connecterWifi("Livebox-5G");
        System.out.println("Connecté: " + phone.estConnecte());

        System.out.println("\n=== ORDINATEUR PORTABLE ===");
        laptop.afficherCaracteristiques();
        laptop.allumer();
        laptop.afficherBatterie();
        laptop.afficherPortabilite();
        laptop.connecterWifi("Bureau-WiFi");
        System.out.println("Connecté: " + laptop.estConnecte());

        System.out.println("\n=== TABLETTE ===");
        tablet.afficherCaracteristiques();
        tablet.allumer();
        tablet.afficherBatterie();
        tablet.afficherPortabilite();

        cycleRecharge(phone);
        cycleRecharge(laptop);
        cycleRecharge(tablet);
    }
}
