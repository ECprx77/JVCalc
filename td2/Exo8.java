package td2;

public class Exo8 {
    public static void main(String[] args) {
        int[] temps = {15, 18, 12, 22, 19, 24, 16};

        int min = temps[0];
        int max = temps[0];

        for (int t : temps) {
            if (t < min) min = t;
            if (t > max) max = t;
        }

        System.out.println("Temperature minimale : " + min + " C");
        System.out.println("Temperature maximale : " + max + " C");

        System.out.print("Jours > 20 C : ");
        boolean first = true;
        for (int t : temps) {
            if (t > 20) {
                if (!first) System.out.print(", ");
                System.out.print(t + " C");
                first = false;
            }
        }
        System.out.println();

        System.out.println("Ecart de temperature : " + (max - min) + " C");
    }
}
