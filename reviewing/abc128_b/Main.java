import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] S = new String[N];
        int[] P = new int[N];
        for (int i = 0; i < N; ++i) {
            S[i] = sc.next();
            P[i] = sc.nextInt();
        }

        System.out.println(solve(S, P));

        sc.close();
    }

    static String solve(String[] S, int[] P) {
        return IntStream.range(0, S.length).boxed()
                .sorted((i1, i2) -> !S[i1].equals(S[i2]) ? S[i1].compareTo(S[i2]) : -Integer.compare(P[i1], P[i2]))
                .map(i -> String.valueOf(i + 1)).collect(Collectors.joining("\n"));
    }
}