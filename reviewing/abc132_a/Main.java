import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        System.out.println(solve(S) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(String S) {
        char[] letters = S.toCharArray();
        Arrays.sort(letters);

        return letters[0] == letters[1] && letters[1] != letters[2] && letters[2] == letters[3];
    }
}