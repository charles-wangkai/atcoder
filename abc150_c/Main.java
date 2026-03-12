import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] P = new int[N];
    for (int i = 0; i < P.length; ++i) {
      P[i] = sc.nextInt();
    }
    int[] Q = new int[N];
    for (int i = 0; i < Q.length; ++i) {
      Q[i] = sc.nextInt();
    }

    System.out.println(solve(P, Q));

    sc.close();
  }

  static int solve(int[] P, int[] Q) {
    int N = P.length;

    List<String> keys = new ArrayList<>();
    search(keys, IntStream.rangeClosed(1, N).toArray(), 0);
    Collections.sort(keys);

    Map<String, Integer> keyToIndex =
        IntStream.range(0, keys.size()).boxed().collect(Collectors.toMap(keys::get, i -> i));

    return Math.abs(keyToIndex.get(generateKey(P)) - keyToIndex.get(generateKey(Q)));
  }

  static void search(List<String> keys, int[] values, int index) {
    if (index == values.length) {
      keys.add(generateKey(values));

      return;
    }

    for (int i = index; i < values.length; ++i) {
      swap(values, i, index);
      search(keys, values, index + 1);
      swap(values, i, index);
    }
  }

  static void swap(int[] a, int index1, int index2) {
    int temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }

  static String generateKey(int[] a) {
    return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(","));
  }
}