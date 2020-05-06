import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        char[][] pixels = new char[H][W];
        for (int r = 0; r < H; ++r) {
            String line = sc.next();
            for (int c = 0; c < W; ++c) {
                pixels[r][c] = line.charAt(c);
            }
        }

        System.out.println(solve(pixels));

        sc.close();
    }

    static String solve(char[][] pixels) {
        int H = pixels.length;
        int W = pixels[0].length;

        char[][] result = new char[H + 2][W + 2];
        for (int r = 0; r < result.length; ++r) {
            for (int c = 0; c < result[r].length; ++c) {
                result[r][c] = (r == 0 || r == H + 1 || c == 0 || c == W + 1) ? '#' : pixels[r - 1][c - 1];
            }
        }

        return Arrays.stream(result).map(String::new).collect(Collectors.joining("\n"));
    }
}