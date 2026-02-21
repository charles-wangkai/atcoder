import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String Sp = sc.next();
        String T = sc.next();

        System.out.println(solve(Sp, T));

        sc.close();
    }

    static String solve(String Sp, String T) {
        for (int i = Sp.length() - T.length(); i >= 0; --i) {
            int i_ = i;
            if (IntStream.range(0, T.length())
                    .allMatch(j -> Sp.charAt(i_ + j) == '?' || Sp.charAt(i_ + j) == T.charAt(j))) {
                return String.format("%s%s%s", Sp.substring(0, i), T, Sp.substring(i + T.length())).replace('?', 'a');
            }
        }

        return "UNRESTORABLE";
    }
}