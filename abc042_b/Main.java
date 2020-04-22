import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextInt();
        String[] S = new String[N];
        for (int i = 0; i < S.length; ++i) {
            S[i] = sc.next();
        }

        System.out.println(solve(S));

        sc.close();
    }

    static String solve(String[] S) {
        return Arrays.stream(S).sorted().collect(Collectors.joining());
    }
}