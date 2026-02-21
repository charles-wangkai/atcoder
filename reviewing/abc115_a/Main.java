import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int D = sc.nextInt();

        System.out.println(solve(D));

        sc.close();
    }

    static String solve(int D) {
        if (D == 25) {
            return "Christmas";
        } else if (D == 24) {
            return "Christmas Eve";
        } else if (D == 23) {
            return "Christmas Eve Eve";
        } else {
            return "Christmas Eve Eve Eve";
        }
    }
}