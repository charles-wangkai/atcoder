import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int Q = sc.nextInt();
    int[] A = new int[Q];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(int[] A) {
    boolean[] result = new boolean[A.length];
    int volume = 0;
    boolean playing = false;
    for (int i = 0; i < result.length; ++i) {
      if (A[i] == 1) {
        ++volume;
      } else if (A[i] == 2) {
        volume = Math.max(0, volume - 1);
      } else {
        playing ^= true;
      }

      result[i] = volume >= 3 && playing;
    }

    return IntStream.range(0, result.length)
        .mapToObj(i -> result[i] ? "Yes" : "No")
        .collect(Collectors.joining("\n"));
  }
}