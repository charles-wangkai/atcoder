import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int X = sc.nextInt();
        int[] L = new int[N];
        for (int i = 0; i < L.length; ++i) {
            L[i] = sc.nextInt();
        }

        System.out.println(solve(L, X));

        sc.close();
    }

    static int solve(int[] L, int X) {
        int result = 1;
        int pos = 0;
        for (int Li : L) {
            pos += Li;
            if (pos <= X) {
                ++result;
            }
        }

        return result;
    }
}