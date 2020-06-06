import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(solve(A, B, C));

        sc.close();
    }

    static int solve(int A, int B, int C) {
        int[] values = { A, B, C };
        int result = 0;
        while (true) {
            Arrays.sort(values);
            if (values[0] == values[2]) {
                break;
            }

            if (values[0] + 2 <= values[1]) {
                values[0] += 2;
            } else {
                ++values[0];
                ++values[1];
            }

            ++result;
        }

        return result;
    }
}