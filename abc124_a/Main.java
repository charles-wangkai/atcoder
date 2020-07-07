import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(solve(A, B));

        sc.close();
    }

    static int solve(int A, int B) {
        return IntStream.of(A * 2 - 1, B * 2 - 1, A + B).max().getAsInt();
    }
}