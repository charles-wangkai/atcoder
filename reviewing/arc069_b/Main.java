import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextInt();
        String s = sc.next();

        System.out.println(solve(s));

        sc.close();
    }

    static String solve(String s) {
        for (String prefix : new String[] { "SS", "SW", "WS", "WW" }) {
            String assignment = buildAssignment(s, prefix);
            if (assignment != null) {
                return assignment;
            }
        }

        return "-1";
    }

    static String buildAssignment(String s, String prefix) {
        StringBuilder result = new StringBuilder(prefix);
        for (int i = 1; i < s.length() - 1; ++i) {
            result.append(another(s, result, i, result.charAt(i - 1)));
        }

        return (another(s, result, result.length() - 1, result.charAt(result.length() - 2)) == result.charAt(0)
                && another(s, result, 0, result.charAt(1)) == result.charAt(result.length() - 1)) ? result.toString()
                        : null;
    }

    static char another(String s, StringBuilder assignment, int index, char neighbor) {
        if (assignment.charAt(index) == 'S') {
            if (s.charAt(index) == 'o') {
                return neighbor;
            } else {
                return invert(neighbor);
            }
        } else {
            if (s.charAt(index) == 'o') {
                return invert(neighbor);
            } else {
                return neighbor;
            }
        }
    }

    static char invert(char neighbor) {
        return (neighbor == 'S') ? 'W' : 'S';
    }
}