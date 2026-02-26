import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int A = sc.nextInt();
    int B = sc.nextInt();
    long[] v = new long[N];
    for (int i = 0; i < v.length; ++i) {
      v[i] = sc.nextLong();
    }

    System.out.println(solve(v, A, B));

    sc.close();
  }

  static String solve(long[] v, int A, int B) {
    long[] sorted =
        Arrays.stream(v)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToLong(Long::longValue)
            .toArray();

    double avg = IntStream.range(0, A).mapToLong(i -> sorted[i]).average().getAsDouble();

    long last = sorted[A - 1];
    int lastCount = (int) Arrays.stream(v).filter(x -> x == last).count();
    int lastChosen = (int) IntStream.range(0, A).filter(i -> sorted[i] == last).count();
    long wayNum = C(lastCount, lastChosen);
    if (sorted[0] == last) {
      for (int i = A + 1; i <= B && sorted[i - 1] == last; ++i) {
        ++lastChosen;
        wayNum += C(lastCount, lastChosen);
      }
    }

    return "%.9f\n%d".formatted(avg, wayNum);
  }

  static long C(int n, int r) {
    long result = 1;
    for (int i = 0; i < r; ++i) {
      result = result * (n - i) / (i + 1);
    }

    return result;
  }
}