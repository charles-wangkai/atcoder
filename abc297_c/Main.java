import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    char[][] room = new char[H][W];
    for (int r = 0; r < H; ++r) {
      String line = sc.next();
      for (int c = 0; c < W; ++c) {
        room[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(room));

    sc.close();
  }

  static String solve(char[][] room) {
    int H = room.length;
    int W = room[0].length;

    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W - 1; ++c) {
        if (room[r][c] == 'T' && room[r][c + 1] == 'T') {
          room[r][c] = 'P';
          room[r][c + 1] = 'C';
        }
      }
    }

    return Arrays.stream(room).map(String::valueOf).collect(Collectors.joining("\n"));
  }
}