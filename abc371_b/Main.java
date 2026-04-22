import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[M];
    char[] B = new char[M];
    for (int i = 0; i < M; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.next().charAt(0);
    }

    System.out.println(solve(N, A, B));

    sc.close();
  }

  static String solve(int N, int[] A, char[] B) {
    String[] result = new String[A.length];
    Set<Integer> familyEldestSonSeen = new HashSet<>();
    for (int i = 0; i < result.length; ++i) {
      if (B[i] == 'M' && !familyEldestSonSeen.contains(A[i])) {
        result[i] = "Yes";
        familyEldestSonSeen.add(A[i]);
      } else {
        result[i] = "No";
      }
    }

    return String.join("\n", result);
  }
}