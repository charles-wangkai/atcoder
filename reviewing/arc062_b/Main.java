import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(solve(s));

        sc.close();
    }

    static int solve(String s) {
        return IntStream.range(0, s.length()).map(i -> {
            char t = s.charAt(i);
            char a = (i % 2 == 0) ? 'g' : 'p';

            if (a == t) {
                return 0;
            } else if (a == 'p') {
                return 1;
            } else {
                return -1;
            }
        }).sum();
    }
}