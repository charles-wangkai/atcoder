import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();
    int D = sc.nextInt();

    System.out.println(solve(A, B, D));

    sc.close();
  }

  static String solve(int A, int B, int D) {
    List<Integer> result = new ArrayList<>();
    result.add(A);
    while (result.getLast() != B) {
      result.add(result.getLast() + D);
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}