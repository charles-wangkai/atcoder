import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S, M) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String[] S, int M) {
    return search(S, M, 0);
  }

  static boolean search(String[] S, int M, int index) {
    if (index == S.length) {
      return IntStream.range(0, S.length - 1)
          .allMatch(
              i ->
                  IntStream.range(0, M).filter(j -> S[i].charAt(j) != S[i + 1].charAt(j)).count()
                      == 1);
    }

    for (int i = index; i < S.length; ++i) {
      swap(S, i, index);

      if (search(S, M, index + 1)) {
        return true;
      }

      swap(S, i, index);
    }

    return false;
  }

  static void swap(String[] S, int index1, int index2) {
    String temp = S[index1];
    S[index1] = S[index2];
    S[index2] = temp;
  }
}