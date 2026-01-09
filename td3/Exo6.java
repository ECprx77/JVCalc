package td3;

class ReservationHotel {
    private String reservationNumber;
    private String clientName;
    private int nights;
    private double pricePerNight;

    ReservationHotel(String reservationNumber, String clientName, int nights, double pricePerNight) {
        this.reservationNumber = reservationNumber;
        this.clientName = clientName;
        this.nights = nights;
        this.pricePerNight = pricePerNight;
    }

    String getReservationNumber() { return reservationNumber; }
    String getClientName() { return clientName; }
    int getNights() { return nights; }
    double getPricePerNight() { return pricePerNight; }

    void setNights(int nights) {
        if (nights >= 1 && nights <= 30) {
            this.nights = nights;
            System.out.println("Nombre de nuits modifié à " + nights);
        } else {
            System.out.println("Erreur : le nombre de nuits doit être entre 1 et 30");
        }
    }

    void setPricePerNight(double price) {
        if (price >= 50.0 && price <= 1000.0) {
            this.pricePerNight = price;
            System.out.println("Prix par nuit modifié à " + price + "€");
        } else {
            System.out.println("Erreur : le prix doit être entre 50€ et 1000€");
        }
    }

    double calculerCoutTotal() {
        return nights * pricePerNight;
    }
}

public class Exo6 {
    public static void main(String[] args) {
        ReservationHotel res = new ReservationHotel("RES2025001", "Marie Dubois", 3, 120.00);

        System.out.println("Coût total initial : " + res.calculerCoutTotal() + "€");

        System.out.println("\nTentative de modification à 35 nuits :");
        res.setNights(35);

        System.out.println("\nModification à 5 nuits :");
        res.setNights(5);

        System.out.println("\nNouveau coût total : " + res.calculerCoutTotal() + "€");
    }
}
