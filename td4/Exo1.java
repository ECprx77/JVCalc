abstract class InstrumentMusique {
    protected String name;
    protected String type;
    protected double price;

    InstrumentMusique(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    abstract void jouer();
    abstract void accorder();

    void afficherInfo() {
        System.out.println("Nom: " + name + " | Type: " + type + " | Prix HT: " + price + "€");
    }

    double calculerPrixAvecTVA() {
        return price * 1.20;
    }
}

class Guitare extends InstrumentMusique {
    int strings;

    Guitare(String name, double price, int strings) {
        super(name, "Cordes", price);
        this.strings = strings;
    }

    void jouer() {
        System.out.println("♪ Gratte les " + strings + " cordes... Ting ting ting ! ");
    }

    void accorder() {
        System.out.println("Accordage des " + strings + " cordes : Mi La Ré Sol Si Mi");
    }
}

class Piano extends InstrumentMusique {
    int keys;

    Piano(String name, double price, int keys) {
        super(name, "Cordes", price);
        this.keys = keys;
    }

    void jouer() {
        System.out.println("♪ Appuie sur les " + keys + " touches... Plin plin plin ! ");
    }

    void accorder() {
        System.out.println("Accordage professionnel requis par un technicien spécialisé");
    }
}

class Batterie extends InstrumentMusique {
    int drums;

    Batterie(String name, double price, int drums) {
        super(name, "Percussion", price);
        this.drums = drums;
    }

    void jouer() {
        System.out.println("♪ Frappe les " + drums + " fûts... Boom tac boom tac ! ");
    }

    void accorder() {
        System.out.println("Ajustement de la tension des peaux sur les " + drums + " fûts");
    }
}

public class Exo1 {
    public static void main(String[] args) {
        InstrumentMusique[] instruments = {
            new Guitare("Fender Stratocaster", 899.99, 6),
            new Piano("Yamaha U1", 4500.00, 88),
            new Batterie("Pearl Export", 750.00, 5)
        };

        for (InstrumentMusique i : instruments) {
            System.out.println("========================");
            i.afficherInfo();
            i.jouer();
            i.accorder();
            System.out.println("Prix TTC: " + i.calculerPrixAvecTVA() + "€");
        }
    }
}
