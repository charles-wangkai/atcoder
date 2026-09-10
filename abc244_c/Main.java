import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    solve(sc, N);

    sc.close();
  }

  static void solve(Scanner sc, int N) {
    Set<Integer> rests = IntStream.rangeClosed(1, 2 * N + 1).boxed().collect(Collectors.toSet());
    while (true) {
      int chosen = rests.iterator().next();
      rests.remove(chosen);

      System.out.println(chosen);
      System.out.flush();

      int reponse = sc.nextInt();
      if (reponse == 0) {
        break;
      }
      rests.remove(reponse);
    }
  }
}