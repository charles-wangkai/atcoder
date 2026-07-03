import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final String KEYBOARD = "wbwbwwbwbwbw";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int W = sc.nextInt();
    int B = sc.nextInt();

    System.out.println(solve(W, B) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int W, int B) {
    return IntStream.range(0, KEYBOARD.length())
        .anyMatch(
            beginIndex -> {
              int wCount = 0;
              int bCount = 0;
              for (int i = 0; i < W + B; ++i) {
                if (KEYBOARD.charAt((beginIndex + i) % KEYBOARD.length()) == 'w') {
                  ++wCount;
                } else {
                  ++bCount;
                }
              }

              return wCount == W && bCount == B;
            });
  }
}