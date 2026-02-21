import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H1 = sc.nextInt();
        int H2 = sc.nextInt();

        System.out.println(solve(H1, H2));

        sc.close();
    }

    static int solve(int H1, int H2) {
        return H1 - H2;
    }
}