import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = new String[3];
        for (int i = 0; i < s.length; ++i) {
            s[i] = sc.next();
        }

        System.out.println(solve(s));

        sc.close();
    }

    static String solve(String[] s) {
        return Arrays.stream(s).map(si -> String.valueOf(Character.toUpperCase(si.charAt(0))))
                .collect(Collectors.joining());
    }
}