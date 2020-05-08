import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextInt();
        String S = sc.next();

        System.out.println(solve(S));

        sc.close();
    }

    static String solve(String S) {
        int prefixLength = 0;
        int depth = 0;
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                ++depth;
            } else if (depth == 0) {
                ++prefixLength;
            } else {
                --depth;
            }
        }

        int suffixLength = depth;

        return String.format("%s%s%s", repeat('(', prefixLength), S, repeat(')', suffixLength));
    }

    static String repeat(char ch, int count) {
        return IntStream.range(0, count).mapToObj(i -> String.valueOf(ch)).collect(Collectors.joining());
    }
}