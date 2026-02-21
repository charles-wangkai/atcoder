import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(solve(s));

        sc.close();
    }

    static String solve(String s) {
        return IntStream.range(0, s.length()).filter(i -> i % 2 == 0).mapToObj(i -> String.valueOf(s.charAt(i)))
                .collect(Collectors.joining());
    }
}