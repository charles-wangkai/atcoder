import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int h = sc.nextInt();

        System.out.println(solve(a, b, h));

        sc.close();
    }

    static int solve(int a, int b, int h) {
        return (a + b) * h / 2;
    }
}