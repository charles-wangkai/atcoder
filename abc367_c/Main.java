import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] R = new int[N];
    for (int i = 0; i < R.length; ++i) {
      R[i] = sc.nextInt();
    }

    System.out.println(solve(R, K));

    sc.close();
  }

  static String solve(int[] R, int K) {
    List<int[]> sequences = new ArrayList<>();
    search(sequences, R, K, new int[R.length], 0);

    return sequences.stream()
        .map(
            sequence ->
                Arrays.stream(sequence).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }

  static void search(List<int[]> sequences, int[] R, int K, int[] sequence, int index) {
    if (index == sequence.length) {
      if (Arrays.stream(sequence).sum() % K == 0) {
        sequences.add(sequence.clone());
      }

      return;
    }

    for (int i = 1; i <= R[index]; ++i) {
      sequence[index] = i;
      search(sequences, R, K, sequence, index + 1);
    }
  }
}