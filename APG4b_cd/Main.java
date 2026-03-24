import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final int SIZE = 9;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[][] A = new int[SIZE][SIZE];
    for (int i = 0; i < SIZE; ++i) {
      for (int j = 0; j < SIZE; ++j) {
        A[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(int[][] A) {
    int[][] products = new int[SIZE][SIZE];
    int correctCount = 0;
    int wrongCount = 0;
    for (int i = 0; i < SIZE; ++i) {
      for (int j = 0; j < SIZE; ++j) {
        products[i][j] = (i + 1) * (j + 1);

        if (products[i][j] == A[i][j]) {
          ++correctCount;
        } else {
          ++wrongCount;
        }
      }
    }

    return "%s\n%d\n%d"
        .formatted(
            Arrays.stream(products)
                .map(
                    line ->
                        Arrays.stream(line)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n")),
            correctCount,
            wrongCount);
  }
}