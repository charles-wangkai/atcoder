import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();
    int Q = sc.nextInt();
    int[] T = new int[Q];
    int[] A = new int[Q];
    int[] B = new int[Q];
    for (int i = 0; i < Q; ++i) {
      T[i] = sc.nextInt();
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(S, T, A, B));

    sc.close();
  }

  static String solve(String S, int[] T, int[] A, int[] B) {
    int N = S.length() / 2;

    char[][] letters = new char[2][];
    letters[0] = S.substring(0, N).toCharArray();
    letters[1] = S.substring(N).toCharArray();

    for (int i = 0; i < T.length; ++i) {
      if (T[i] == 1) {
        int segment1 = (A[i] - 1) / N;
        int pos1 = (A[i] - 1) % N;

        int segment2 = (B[i] - 1) / N;
        int pos2 = (B[i] - 1) % N;

        char temp = letters[segment1][pos1];
        letters[segment1][pos1] = letters[segment2][pos2];
        letters[segment2][pos2] = temp;
      } else {
        char[] temp = letters[0];
        letters[0] = letters[1];
        letters[1] = temp;
      }
    }

    return Arrays.stream(letters).map(String::valueOf).collect(Collectors.joining());
  }
}