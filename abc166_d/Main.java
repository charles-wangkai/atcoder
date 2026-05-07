import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();

    System.out.println(solve(X));

    sc.close();
  }

  static String solve(int X) {
    List<Integer> bases = new ArrayList<>();
    bases.add(0);
    for (int base = 1; pow5(base) - pow5(base - 1) <= X; ++base) {
      bases.add(base);
    }

    for (int i = 0; ; ++i) {
      for (int j = 0; j <= i; ++j) {
        if (pow5(bases.get(i)) - pow5(bases.get(j)) == X) {
          return "%d %d".formatted(bases.get(i), bases.get(j));
        }
        if (pow5(bases.get(i)) - pow5(-bases.get(j)) == X) {
          return "%d %d".formatted(bases.get(i), -bases.get(j));
        }
      }
    }
  }

  static long pow5(int x) {
    return (long) x * x * x * x * x;
  }
}