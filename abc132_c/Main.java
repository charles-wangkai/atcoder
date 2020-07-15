import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] d = new int[N];
        for (int i = 0; i < d.length; ++i) {
            d[i] = sc.nextInt();
        }

        System.out.println(solve(d));

        sc.close();
    }

    static int solve(int[] d) {
        d = Arrays.stream(d).boxed().sorted().mapToInt(x -> x).toArray();

        return d[d.length / 2] - d[d.length / 2 - 1];
    }
}