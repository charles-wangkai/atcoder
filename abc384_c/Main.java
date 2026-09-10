import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();
    int e = sc.nextInt();

    System.out.println(solve(a, b, c, d, e));

    sc.close();
  }

  static String solve(int a, int b, int c, int d, int e) {
    int[] scores = {a, b, c, d, e};

    int[] participantScores =
        IntStream.range(0, 1 << scores.length)
            .map(
                mask ->
                    IntStream.range(0, scores.length)
                        .filter(i -> ((mask >> i) & 1) == 1)
                        .map(i -> scores[i])
                        .sum())
            .toArray();

    String[] names =
        IntStream.range(0, 1 << scores.length)
            .mapToObj(
                mask ->
                    IntStream.range(0, scores.length)
                        .filter(i -> ((mask >> i) & 1) == 1)
                        .mapToObj(i -> (char) (i + 'A'))
                        .map(String::valueOf)
                        .collect(Collectors.joining()))
            .toArray(String[]::new);

    return IntStream.range(1, 1 << scores.length)
        .boxed()
        .sorted(
            Comparator.<Integer, Integer>comparing(i -> participantScores[i])
                .reversed()
                .thenComparing(Comparator.comparing(i -> names[i])))
        .map(i -> names[i])
        .collect(Collectors.joining("\n"));
  }
}