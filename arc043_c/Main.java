import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] B = new int[N];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B));

    sc.close();
  }

  static String solve(int[] A, int[] B) {
    Map<Integer, Integer> valueToIndexA =
        IntStream.range(0, A.length)
            .boxed()
            .collect(Collectors.toMap(i -> A[i], Function.identity()));

    int[] leftReversedCounts = new int[B.length];
    FenwickTree fenwickTree = new FenwickTree(B.length);
    for (int i = 0; i < B.length; ++i) {
      int target = valueToIndexA.get(B[i]) + 1;

      leftReversedCounts[i] = i - fenwickTree.computePrefixSum(target);
      fenwickTree.add(target, 1);
    }

    long reversedCount = Arrays.stream(leftReversedCounts).asLongStream().sum();
    if (reversedCount % 2 == 1) {
      return "-1";
    }

    long needed = reversedCount / 2;
    Map<Integer, Integer> valueToIndexB =
        IntStream.range(0, B.length)
            .boxed()
            .collect(Collectors.toMap(i -> B[i], Function.identity()));
    int[] C = new int[B.length];
    int index = 0;
    Set<Integer> used = new HashSet<>();
    while (true) {
      int bIndex = valueToIndexB.get(A[index]);
      if (leftReversedCounts[bIndex] >= needed) {
        break;
      }

      C[index] = A[index];
      used.add(C[index]);
      needed -= leftReversedCounts[bIndex];
      ++index;
    }

    int currentValue = A[index];

    for (int i = 0; i < B.length; ++i) {
      if (!used.contains(B[i])) {
        C[index] = B[i];
        ++index;
      }
    }

    int currentIndex = 0;
    while (C[currentIndex] != currentValue) {
      ++currentIndex;
    }

    while (needed != 0) {
      int temp = C[currentIndex];
      C[currentIndex] = C[currentIndex - 1];
      C[currentIndex - 1] = temp;

      --currentIndex;
      --needed;
    }

    return Arrays.stream(C).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}

class FenwickTree {
  int[] a;

  FenwickTree(int size) {
    a = new int[Integer.highestOneBit(size) * 2 + 1];
  }

  void add(int pos, int delta) {
    while (pos < a.length) {
      a[pos] += delta;
      pos += pos & -pos;
    }
  }

  int computePrefixSum(int pos) {
    int result = 0;
    while (pos != 0) {
      result += a[pos];
      pos -= pos & -pos;
    }

    return result;
  }
}
