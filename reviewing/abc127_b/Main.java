import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int D = sc.nextInt();
        int x = sc.nextInt();

        System.out.println(solve(r, D, x));

        sc.close();
    }

    static String solve(int r, int D, int x) {
        int[] result = new int[10];
        for (int i = 0; i < result.length; ++i) {
            x = r * x - D;
            result[i] = x;
        }

        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
    }
}