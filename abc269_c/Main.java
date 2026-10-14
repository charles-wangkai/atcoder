import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();

    System.out.println(solve(N));

    sc.close();
  }

  static String solve(long N) {
    List<Long> result = new ArrayList<>();
    long sub = N;
    while (true) {
      result.add(sub);
      if (sub == 0) {
        break;
      }

      sub = (sub - 1) & N;
    }
    Collections.sort(result);

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}