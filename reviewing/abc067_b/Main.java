import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] l = new int[N];
        for (int i = 0; i < l.length; ++i) {
            l[i] = sc.nextInt();
        }

        System.out.println(solve(l, K));

        sc.close();
    }

    static int solve(int[] l, int K) {
        return Arrays.stream(l).sorted().skip(l.length - K).sum();
    }
}