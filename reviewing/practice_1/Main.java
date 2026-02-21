import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        String s = sc.next();

        System.out.println(solve(a, b, c, s));

        sc.close();
    }

    static String solve(int a, int b, int c, String s) {
        return String.format("%d %s", a + b + c, s);
    }
}