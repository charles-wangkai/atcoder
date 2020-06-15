import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        System.out.println(solve(S));

        sc.close();
    }

    static int solve(String S) {
        return S.chars().reduce(0, (result, ch) -> result + ((ch == '+') ? 1 : -1));
    }
}