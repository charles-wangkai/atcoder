import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    int[] A = new int[Q];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(N, A));

    sc.close();
  }

  static String solve(int N, int[] A) {
    int[] result = new int[A.length];
    boolean[] blacks = new boolean[N];
    int blackIntervalNum = 0;
    for (int i = 0; i < result.length; ++i) {
      int index = A[i] - 1;

      blacks[index] ^= true;

      if (blacks[index]) {
        if ((index == 0 || !blacks[index - 1])
            && (index == blacks.length - 1 || !blacks[index + 1])) {
          ++blackIntervalNum;
        } else if (index != 0
            && blacks[index - 1]
            && index != blacks.length - 1
            && blacks[index + 1]) {
          --blackIntervalNum;
        }
      } else if ((index == 0 || !blacks[index - 1])
          && (index == blacks.length - 1 || !blacks[index + 1])) {
        --blackIntervalNum;
      } else if (index != 0
          && blacks[index - 1]
          && index != blacks.length - 1
          && blacks[index + 1]) {
        ++blackIntervalNum;
      }

      result[i] = blackIntervalNum;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}