import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        System.out.println(solve(s, t) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(String s, String t) {
        return s.chars().sorted().mapToObj(ch -> String.valueOf((char) ch)).collect(Collectors.joining())
                .compareTo(t.chars().boxed().sorted(Collections.reverseOrder())
                        .map(x -> String.valueOf((char) x.intValue())).collect(Collectors.joining())) < 0;
    }
}