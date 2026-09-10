import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int A = sc.nextInt();
    int B = sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S, A, B));

    sc.close();
  }

  static String solve(String S, int A, int B) {
    boolean[] passed = new boolean[S.length()];
    int passedCount = 0;
    int overseasPassedCount = 0;
    for (int i = 0; i < passed.length; ++i) {
      if (S.charAt(i) == 'a') {
        if (passedCount < A + B) {
          passed[i] = true;
          ++passedCount;
        }
      } else if (S.charAt(i) == 'b' && passedCount < A + B && overseasPassedCount < B) {
        passed[i] = true;
        ++passedCount;
        ++overseasPassedCount;
      }
    }

    return IntStream.range(0, passed.length)
        .mapToObj(i -> passed[i] ? "Yes" : "No")
        .collect(Collectors.joining("\n"));
  }
}