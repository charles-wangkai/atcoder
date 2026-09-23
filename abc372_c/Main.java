import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int Q = sc.nextInt();
    String S = sc.next();
    int[] X = new int[Q];
    char[] C = new char[Q];
    for (int i = 0; i < Q; ++i) {
      X[i] = sc.nextInt();
      C[i] = sc.next().charAt(0);
    }

    System.out.println(solve(S, X, C));

    sc.close();
  }

  static String solve(String S, int[] X, char[] C) {
    int Q = X.length;

    int[] result = new int[Q];
    char[] letters = S.toCharArray();
    int matchedCount =
        (int)
            IntStream.rangeClosed(0, letters.length - 3).filter(i -> isMatched(letters, i)).count();
    for (int i = 0; i < result.length; ++i) {
      int index = X[i] - 1;

      matchedCount -= computeAffectedMatchedNum(letters, index);
      letters[index] = C[i];
      matchedCount += computeAffectedMatchedNum(letters, index);

      result[i] = matchedCount;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }

  static int computeAffectedMatchedNum(char[] letters, int index) {
    return (int)
        IntStream.rangeClosed(-2, 0).filter(offset -> isMatched(letters, index + offset)).count();
  }

  static boolean isMatched(char[] letters, int beginIndex) {
    return getLetter(letters, beginIndex) == 'A'
        && getLetter(letters, beginIndex + 1) == 'B'
        && getLetter(letters, beginIndex + 2) == 'C';
  }

  static char getLetter(char[] letters, int index) {
    return (index >= 0 && index < letters.length) ? letters[index] : 0;
  }
}