import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        System.out.println(solve(S));

        sc.close();
    }

    static String solve(String S) {
        return IntStream.range(0, S.length() - 1).anyMatch(i -> S.charAt(i) == S.charAt(i + 1)) ? "Bad" : "Good";
    }
}