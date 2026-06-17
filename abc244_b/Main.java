import java.util.Scanner;

public class Main {
  static final int[] X_OFFSETS = {1, 0, -1, 0};
  static final int[] Y_OFFSETS = {0, -1, 0, 1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String T = sc.next();

    System.out.println(solve(T));

    sc.close();
  }

  static String solve(String T) {
    int x = 0;
    int y = 0;
    int direction = 0;
    for (char c : T.toCharArray()) {
      if (c == 'S') {
        x += X_OFFSETS[direction];
        y += Y_OFFSETS[direction];
      } else {
        direction = (direction + 1) % X_OFFSETS.length;
      }
    }

    return "%d %d".formatted(x, y);
  }
}