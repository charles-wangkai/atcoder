import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        System.out.println(solve(S));

        sc.close();
    }

    static String solve(String S) {
        Set<Integer> seen = S.chars().boxed().collect(Collectors.toSet());

        return IntStream.rangeClosed('a', 'z').filter(ch -> !seen.contains(ch))
                .mapToObj(ch -> String.valueOf((char) ch)).findAny().orElse("None");
    }
}