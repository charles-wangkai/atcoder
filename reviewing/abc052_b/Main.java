import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextInt();
        String S = sc.next();

        System.out.println(solve(S));

        sc.close();
    }

    static int solve(String S) {
        int result = 0;
        int x = 0;
        for (char ch : S.toCharArray()) {
            x = x + (ch == 'I' ? 1 : -1);
            result = Math.max(result, x);
        }

        return result;
    }
}