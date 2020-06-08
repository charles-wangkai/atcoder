import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int X = sc.nextInt();
        int[] m = new int[N];
        for (int i = 0; i < m.length; ++i) {
            m[i] = sc.nextInt();
        }

        System.out.println(solve(m, X));

        sc.close();
    }

    static int solve(int[] m, int X) {
        return m.length + (X - Arrays.stream(m).sum()) / Arrays.stream(m).min().getAsInt();
    }
}