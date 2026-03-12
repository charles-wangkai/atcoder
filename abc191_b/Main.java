import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int X = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, X));

    sc.close();
  }

  static String solve(int[] A, int X) {
    return Arrays.stream(A)
        .filter(Ai -> Ai != X)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}