import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(solve(N));

        sc.close();
    }

    static String solve(int N) {
        StringBuilder result = new StringBuilder();
        while (N != 0) {
            if (N % 2 != 0) {
                result.append(1);
                --N;
            } else {
                result.append(0);
            }

            N /= -2;
        }

        result.reverse();
        if (result.length() == 0) {
            result.append(0);
        }

        return result.toString();
    }
}