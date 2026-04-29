import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    int[] indices = IntStream.range(0, S.length()).filter(i -> S.charAt(i) == '#').toArray();

    return IntStream.range(0, indices.length / 2)
        .mapToObj(i -> "%d,%d".formatted(indices[i * 2] + 1, indices[i * 2 + 1] + 1))
        .collect(Collectors.joining("\n"));
  }
}