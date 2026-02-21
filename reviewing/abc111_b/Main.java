import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(solve(N));

        sc.close();
    }

    static int solve(int N) {
        int result = N;
        while (String.valueOf(result).chars().distinct().count() != 1) {
            ++result;
        }

        return result;
    }
}