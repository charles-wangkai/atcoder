import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextInt();
        int K = sc.nextInt();
        String S = sc.next();

        System.out.println(solve(S, K));

        sc.close();
    }

    static String solve(String S, int K) {
        return IntStream.range(0, S.length())
                .mapToObj(i -> String.valueOf((i == K - 1) ? Character.toLowerCase(S.charAt(i)) : S.charAt(i)))
                .collect(Collectors.joining());
    }
}