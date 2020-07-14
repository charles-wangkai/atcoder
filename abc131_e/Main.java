import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(solve(N, K));

        sc.close();
    }

    static String solve(int N, int K) {
        if (K > (N - 1) * (N - 2) / 2) {
            return "-1";
        }

        List<String> edges = new ArrayList<>();
        for (int i = 2; i <= N; ++i) {
            edges.add(String.format("%d 1", i));

            for (int j = 2; j < i; ++j) {
                if (K == 0) {
                    edges.add(String.format("%d %d", i, j));
                } else {
                    --K;
                }
            }
        }

        return String.format("%d\n%s", edges.size(), String.join("\n", edges));
    }
}