import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        String S = sc.next();

        System.out.println(solve(A, B, S) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(int A, int B, String S) {
        return IntStream.range(0, S.length())
                .allMatch(i -> (i == A) ? (S.charAt(i) == '-') : Character.isDigit(S.charAt(i)));
    }
}