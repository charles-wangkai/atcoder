import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        String T = sc.next();

        System.out.println(solve(S, T) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(String S, String T) {
        Map<Character, Character> mapping = new HashMap<>();
        Set<Character> tos = new HashSet<>();
        for (int i = 0; i < S.length(); ++i) {
            char from = S.charAt(i);
            char to = T.charAt(i);

            if (mapping.containsKey(from)) {
                if (to != mapping.get(from)) {
                    return false;
                }
            } else {
                if (tos.contains(to)) {
                    return false;
                }

                mapping.put(from, to);
                tos.add(to);
            }
        }

        return true;
    }
}