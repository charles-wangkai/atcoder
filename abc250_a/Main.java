import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    int R = sc.nextInt();
    int C = sc.nextInt();

    System.out.println(solve(H, W, R, C));

    sc.close();
  }

  static int solve(int H, int W, int R, int C) {
    return (int)
        IntStream.range(0, R_OFFSETS.length)
            .filter(
                i -> {
                  int adjR = R + R_OFFSETS[i];
                  int adjC = C + C_OFFSETS[i];

                  return adjR >= 1 && adjR <= H && adjC >= 1 && adjC <= W;
                })
            .count();
  }
}