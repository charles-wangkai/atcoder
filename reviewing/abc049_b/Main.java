import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        char[][] C = new char[H][W];
        for (int r = 0; r < H; ++r) {
            String line = sc.next();
            for (int c = 0; c < W; ++c) {
                C[r][c] = line.charAt(c);
            }
        }

        System.out.println(solve(C));

        sc.close();
    }

    static String solve(char[][] C) {
        return Arrays.stream(C)
                .map(line -> IntStream.range(0, 2).mapToObj(i -> new String(line)).collect(Collectors.joining("\n")))
                .collect(Collectors.joining("\n"));
    }
}