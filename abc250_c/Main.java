import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    int[] x = new int[Q];
    for (int i = 0; i < x.length; ++i) {
      x[i] = sc.nextInt();
    }

    System.out.println(solve(N, x));

    sc.close();
  }

  static String solve(int N, int[] x) {
    int[] balls = IntStream.rangeClosed(1, N).toArray();
    Map<Integer, Integer> ballToIndex =
        IntStream.range(0, balls.length).boxed().collect(Collectors.toMap(i -> balls[i], i -> i));

    for (int xi : x) {
      int index = ballToIndex.get(xi);
      if (index == balls.length - 1) {
        swap(balls, ballToIndex, index, index - 1);
      } else {
        swap(balls, ballToIndex, index, index + 1);
      }
    }

    return Arrays.stream(balls).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static void swap(int[] balls, Map<Integer, Integer> ballToIndex, int index1, int index2) {
    int temp = balls[index1];
    balls[index1] = balls[index2];
    balls[index2] = temp;

    ballToIndex.put(balls[index1], index1);
    ballToIndex.put(balls[index2], index2);
  }
}