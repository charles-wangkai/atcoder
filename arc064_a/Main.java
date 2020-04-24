import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve(a, x));

        sc.close();
    }

    static long solve(int[] a, int x) {
        long result = 0;
        int prev = 0;
        for (int ai : a) {
            int eaten = Math.max(0, ai + prev - x);

            result += eaten;
            prev = ai - eaten;
        }

        return result;
    }
}