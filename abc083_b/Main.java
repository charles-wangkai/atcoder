import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(solve(N, A, B));

        sc.close();
    }

    static int solve(int N, int A, int B) {
        return IntStream.rangeClosed(1, N).filter(x -> {
            int digitSum = String.valueOf(x).chars().map(ch -> ch - '0').sum();

            return digitSum >= A && digitSum <= B;
        }).sum();
    }
}