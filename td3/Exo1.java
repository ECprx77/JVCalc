package td3;

class Livre {
    String title;
    String author;
    int year;
    boolean available;
}

public class Exo1 {
    public static void main(String[] args) {
        Livre b1 = new Livre();
        b1.title = "Le Petit Prince";
        b1.author = "Antoine de Saint-Exupéry";
        b1.year = 1943;
        b1.available = true;

        Livre b2 = new Livre();
        b2.title = "1984";
        b2.author = "George Orwell";
        b2.year = 1949;
        b2.available = false;

        Livre b3 = new Livre();
        b3.title = "L'Étranger";
        b3.author = "Albert Camus";
        b3.year = 1942;
        b3.available = true;

        System.out.println(b1.title + " par " + b1.author + " (" + b1.year + ") - Disponible : " + b1.available);
        System.out.println(b2.title + " par " + b2.author + " (" + b2.year + ") - Disponible : " + b2.available);
        System.out.println(b3.title + " par " + b3.author + " (" + b3.year + ") - Disponible : " + b3.available);
    }
}
