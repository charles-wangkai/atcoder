import java.util.Scanner;

public class Main {
    static final int[] DIGITS = { 0, 3, 5, 7 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(solve(N));

        sc.close();
    }

    static int solve(int N) {
        return search(N, 0, 9);
    }

    static int search(int N, int number, int rest) {
        if (rest == 0) {
            String s = String.valueOf(number);

            return (number <= N && s.indexOf('0') == -1 && s.chars().distinct().count() == 3) ? 1 : 0;
        }

        int result = 0;
        for (int digit : DIGITS) {
            result += search(N, number * 10 + digit, rest - 1);
        }

        return result;
    }
}