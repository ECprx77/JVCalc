package td3;

class Voiture {
    String brand;
    String model;
    int mileage;
    double dailyPrice;
}

public class Exo2 {
    public static void main(String[] args) {
        Voiture[] cars = new Voiture[4];

        cars[0] = new Voiture();
        cars[0].brand = "Renault";
        cars[0].model = "Clio";
        cars[0].mileage = 45000;
        cars[0].dailyPrice = 35.50;

        cars[1] = new Voiture();
        cars[1].brand = "Peugeot";
        cars[1].model = "3008";
        cars[1].mileage = 12000;
        cars[1].dailyPrice = 55.00;

        cars[2] = new Voiture();
        cars[2].brand = "Citroën";
        cars[2].model = "C3";
        cars[2].mileage = 78000;
        cars[2].dailyPrice = 30.00;

        cars[3] = new Voiture();
        cars[3].brand = "Toyota";
        cars[3].model = "Yaris";
        cars[3].mileage = 5000;
        cars[3].dailyPrice = 40.00;

        double totalPrice = 0;
        System.out.println("Voitures avec moins de 50 000 km :");
        for (Voiture car : cars) {
            if (car.mileage < 50000) {
                System.out.println(car.brand + " " + car.model + " - " + car.mileage + " km - " + car.dailyPrice + "€/jour");
                totalPrice += car.dailyPrice * 7;
            }
        }
        System.out.println("\nPrix total pour 7 jours : " + totalPrice + "€");
    }
}
