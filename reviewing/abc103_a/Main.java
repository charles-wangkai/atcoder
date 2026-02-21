import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] A = new int[3];
        for (int i = 0; i < A.length; ++i) {
            A[i] = sc.nextInt();
        }

        System.out.println(solve(A));

        sc.close();
    }

    static int solve(int[] A) {
        return Arrays.stream(A).max().getAsInt() - Arrays.stream(A).min().getAsInt();
    }
}