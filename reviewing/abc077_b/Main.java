import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(solve(N));

        sc.close();
    }

    static int solve(int N) {
        int root = 0;
        while ((root + 1) * (root + 1) <= N) {
            ++root;
        }

        return root * root;
    }
}