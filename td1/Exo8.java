package td1;

public class Exo8 {
    public static void main(String[] args) {
        int totalMin = 135;

        int hrs = totalMin / 60;
        int min = totalMin % 60;

        System.out.println(totalMin + " minutes = " + hrs + " heures et " + min + " minutes");
    }
}
