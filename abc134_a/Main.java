import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();

        System.out.println(solve(r));

        sc.close();
    }

    static int solve(int r) {
        return 3 * r * r;
    }
}