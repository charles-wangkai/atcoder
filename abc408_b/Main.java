import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(int[] A) {
    int[] C = Arrays.stream(A).sorted().distinct().toArray();

    return "%d\n%s"
        .formatted(
            C.length, Arrays.stream(C).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}