import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        int E = sc.nextInt();

        System.out.println(solve(A, B, C, D, E));

        sc.close();
    }

    static int solve(int A, int B, int C, int D, int E) {
        int[] times = { A, B, C, D, E };

        return Arrays.stream(times).map(time -> (time + 9) / 10 * 10).sum()
                - Arrays.stream(times).map(time -> (10 - time % 10) % 10).max().getAsInt();
    }
}