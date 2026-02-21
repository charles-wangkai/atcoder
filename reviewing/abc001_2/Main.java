import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        System.out.println(solve(m));

        sc.close();
    }

    static String solve(int m) {
        if (m < 100) {
            return "00";
        } else if (m <= 5000) {
            return String.format("%02d", m / 100);
        } else if (m <= 30000) {
            return String.valueOf(m / 1000 + 50);
        } else if (m <= 70000) {
            return String.valueOf((m / 1000 - 30) / 5 + 80);
        } else {
            return "89";
        }
    }
}