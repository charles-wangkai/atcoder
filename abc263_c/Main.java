import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    System.out.println(solve(N, M));

    sc.close();
  }

  static String solve(int N, int M) {
    List<int[]> sequences = new ArrayList<>();
    search(sequences, M, new int[N], 0);

    return sequences.stream()
        .map(
            sequence ->
                Arrays.stream(sequence).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }

  static void search(List<int[]> sequences, int M, int[] sequence, int index) {
    if (index == sequence.length) {
      sequences.add(sequence.clone());

      return;
    }

    for (int i = (index == 0) ? 1 : (sequence[index - 1] + 1); i <= M; ++i) {
      sequence[index] = i;
      search(sequences, M, sequence, index + 1);
    }
  }
}