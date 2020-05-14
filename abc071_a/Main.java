import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(solve(x, a, b));

        sc.close();
    }

    static String solve(int x, int a, int b) {
        return (Math.abs(x - a) < Math.abs(x - b)) ? "A" : "B";
    }
}