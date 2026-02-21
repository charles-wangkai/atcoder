import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();

        System.out.println(solve(R));

        sc.close();
    }

    static double solve(int R) {
        return 2 * Math.PI * R;
    }
}