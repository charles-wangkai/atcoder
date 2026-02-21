import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char c = sc.next().charAt(0);

        System.out.println(solve(c));

        sc.close();
    }

    static String solve(char c) {
        return "aeiou".indexOf(c) >= 0 ? "vowel" : "consonant";
    }
}