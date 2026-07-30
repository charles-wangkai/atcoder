import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int M = sc.nextInt();

    System.out.println(solve(M));

    sc.close();
  }

  static String solve(int M) {
    int[] powers = new int[11];
    powers[0] = 1;
    for (int i = 1; i < powers.length; ++i) {
      powers[i] = powers[i - 1] * 3;
    }

    List<Integer> A = new ArrayList<>();
    int index = powers.length - 1;
    while (M != 0) {
      if (powers[index] > M) {
        --index;
      } else {
        A.add(index);
        M -= powers[index];
      }
    }

    return "%d\n%s"
        .formatted(A.size(), A.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}