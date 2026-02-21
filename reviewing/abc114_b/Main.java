import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        System.out.println(solve(S));

        sc.close();
    }

    static int solve(String S) {
        return IntStream.rangeClosed(0, S.length() - 3)
                .map(i -> Math.abs(Integer.parseInt(S.substring(i, i + 3)) - 753)).min().getAsInt();
    }
}