package td1;

public class Exo10 {
    public static void main(String[] args) {
        int x = 5;
        int y = 10;

        System.out.println("Avant : x = " + x + ", y = " + y);

        int tmp = x;
        x = y;
        y = tmp;

        System.out.println("Apres : x = " + x + ", y = " + y);
    }
}
