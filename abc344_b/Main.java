import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    List<Integer> A = new ArrayList<>();
    while (true) {
      int value = sc.nextInt();
      A.add(value);

      if (value == 0) {
        break;
      }
    }

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(List<Integer> A) {
    return IntStream.range(0, A.size())
        .map(i -> A.get(A.size() - 1 - i))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}