import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();

        System.out.println(solve(N, L));

        sc.close();
    }

    static int solve(int N, int L) {
        int[] flavors = IntStream.range(0, N).map(i -> L + i).toArray();

        return Arrays.stream(flavors).sum()
                - Arrays.stream(flavors).boxed().min((f1, f2) -> Integer.compare(Math.abs(f1), Math.abs(f2))).get();
    }
}