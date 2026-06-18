import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    int X = sc.nextInt();
    int[] A = new int[T + 1];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, X));

    sc.close();
  }

  static String solve(int[] A, int X) {
    List<Integer> savedIndices = new ArrayList<>();
    for (int i = 0; i < A.length; ++i) {
      if (savedIndices.isEmpty() || Math.abs(A[i] - A[savedIndices.getLast()]) >= X) {
        savedIndices.add(i);
      }
    }

    return savedIndices.stream()
        .map(index -> "%d %d".formatted(index, A[index]))
        .collect(Collectors.joining("\n"));
  }
}