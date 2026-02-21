import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        char[] S = new char[N];
        for (int i = 0; i < S.length; ++i) {
            S[i] = sc.next().charAt(0);
        }

        System.out.println(solve(S));

        sc.close();
    }

    static String solve(char[] S) {
        return IntStream.range(0, S.length).anyMatch(i -> S[i] == 'Y') ? "Four" : "Three";
    }
}