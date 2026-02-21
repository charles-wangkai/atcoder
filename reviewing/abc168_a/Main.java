import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(solve(N));

        sc.close();
    }

    static String solve(int N) {
        int oneDigit = N % 10;

        if (oneDigit == 3) {
            return "bon";
        } else if (oneDigit == 0 || oneDigit == 1 || oneDigit == 6 || oneDigit == 8) {
            return "pon";
        } else {
            return "hon";
        }
    }
}