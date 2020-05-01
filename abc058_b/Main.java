import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String O = sc.next();
        String E = sc.next();

        System.out.println(solve(O, E));

        sc.close();
    }

    static String solve(String O, String E) {
        char[] result = new char[O.length() + E.length()];
        for (int i = 0; i < result.length; ++i) {
            result[i] = (i % 2 == 0) ? O.charAt(i / 2) : E.charAt(i / 2);
        }

        return new String(result);
    }
}