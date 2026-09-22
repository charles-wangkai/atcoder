import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] a = new int[N];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, K) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] a, int K) {
    @SuppressWarnings("unchecked")
    List<Integer>[] indexLists = new List[K];
    for (int i = 0; i < indexLists.length; ++i) {
      indexLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < a.length; ++i) {
      indexLists[i % K].add(i);
    }

    for (List<Integer> indexList : indexLists) {
      int[] sortedValues =
          indexList.stream().map(index -> a[index]).mapToInt(Integer::intValue).sorted().toArray();

      for (int i = 0; i < indexList.size(); ++i) {
        a[indexList.get(i)] = sortedValues[i];
      }
    }

    return IntStream.range(0, a.length - 1).allMatch(i -> a[i] <= a[i + 1]);
  }
}