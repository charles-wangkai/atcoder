import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(solve(N) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(int N) {
        return N % String.valueOf(N).chars().map(ch -> ch - '0').sum() == 0;
    }
}