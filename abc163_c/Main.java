import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N - 1];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(int[] A) {
    int N = A.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] childLists = new List[N];
    for (int i = 0; i < childLists.length; ++i) {
      childLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < A.length; ++i) {
      childLists[A[i] - 1].add(i + 1);
    }

    return Arrays.stream(childLists)
        .mapToInt(List::size)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}