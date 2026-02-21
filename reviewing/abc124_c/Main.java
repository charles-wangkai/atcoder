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
        return Math.min(computeRepaintNum(S, '0'), computeRepaintNum(S, '1'));
    }

    static int computeRepaintNum(String S, char evenTarget) {
        return (int) IntStream.range(0, S.length()).filter(i -> (i % 2 == 0) == (S.charAt(i) != evenTarget)).count();
    }
}