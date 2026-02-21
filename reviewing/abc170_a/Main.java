import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] x = new int[5];
        for (int i = 0; i < x.length; ++i) {
            x[i] = sc.nextInt();
        }

        System.out.println(solve(x));

        sc.close();
    }

    static int solve(int[] x) {
        return 15 - Arrays.stream(x).sum();
    }
}