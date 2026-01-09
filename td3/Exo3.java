package td3;

class TableRestaurant {
    int number;
    int seats;
    boolean reserved;
    String clientName;
}

public class Exo3 {
    public static void main(String[] args) {
        TableRestaurant[] tables = new TableRestaurant[5];

        tables[0] = new TableRestaurant();
        tables[0].number = 1;
        tables[0].seats = 2;
        tables[0].reserved = false;
        tables[0].clientName = "";

        tables[1] = new TableRestaurant();
        tables[1].number = 2;
        tables[1].seats = 4;
        tables[1].reserved = true;
        tables[1].clientName = "Dupont";

        tables[2] = new TableRestaurant();
        tables[2].number = 3;
        tables[2].seats = 6;
        tables[2].reserved = false;
        tables[2].clientName = "";

        tables[3] = new TableRestaurant();
        tables[3].number = 4;
        tables[3].seats = 2;
        tables[3].reserved = true;
        tables[3].clientName = "Martin";

        tables[4] = new TableRestaurant();
        tables[4].number = 5;
        tables[4].seats = 8;
        tables[4].reserved = false;
        tables[4].clientName = "";

        int totalSeats = 0;
        System.out.println("Tables disponibles :");
        for (TableRestaurant t : tables) {
            if (!t.reserved) {
                System.out.println("Table " + t.number + " - " + t.seats + " places");
                totalSeats += t.seats;
            }
        }
        System.out.println("\nNombre total de places disponibles : " + totalSeats);
    }
}
