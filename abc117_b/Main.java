import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] L = new int[N];
        for (int i = 0; i < L.length; ++i) {
            L[i] = sc.nextInt();
        }

        System.out.println(solve(L) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(int[] L) {
        return Arrays.stream(L).max().getAsInt() * 2 < Arrays.stream(L).sum();
    }
}