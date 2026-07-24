import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static int solve(int[] A) {
    int angle = 0;
    List<Integer> angles = new ArrayList<>();
    angles.add(0);
    for (int Ai : A) {
      angle = (angle + Ai) % 360;
      angles.add(angle);
    }
    Collections.sort(angles);

    return IntStream.range(0, angles.size())
        .map(
            i ->
                ((i == angles.size() - 1) ? (angles.get(0) + 360) : angles.get(i + 1))
                    - angles.get(i))
        .max()
        .getAsInt();
  }
}