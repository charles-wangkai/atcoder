import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();

        System.out.println(solve(X));

        sc.close();
    }

    static int solve(int X) {
        int result = 1;
        for (int b = 2; b * b <= X; ++b) {
            int power = b * b;
            while (power * b <= X) {
                power *= b;
            }

            result = Math.max(result, power);
        }

        return result;
    }
}