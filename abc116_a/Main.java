import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int AB = sc.nextInt();
        int BC = sc.nextInt();
        int CA = sc.nextInt();

        System.out.println(solve(AB, BC, CA));

        sc.close();
    }

    static int solve(int AB, int BC, int CA) {
        return AB * BC / 2;
    }
}