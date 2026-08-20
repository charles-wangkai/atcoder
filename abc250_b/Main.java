import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int A = sc.nextInt();
    int B = sc.nextInt();

    System.out.println(solve(N, A, B));

    sc.close();
  }

  static String solve(int N, int A, int B) {
    char[][] result = new char[N * A][N * B];
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        for (int p = 0; p < A; ++p) {
          for (int q = 0; q < B; ++q) {
            result[i * A + p][j * B + q] = ((i + j) % 2 == 0) ? '.' : '#';
          }
        }
      }
    }

    return Arrays.stream(result).map(String::valueOf).collect(Collectors.joining("\n"));
  }
}