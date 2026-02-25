import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] T = new int[Q];
    int[] L = new int[Q];
    int[] R = new int[Q];
    for (int i = 0; i < Q; ++i) {
      T[i] = sc.nextInt();
      L[i] = sc.nextInt();
      R[i] = sc.nextInt();
    }

    System.out.println(solve(A, T, L, R));

    sc.close();
  }

  static String solve(int[] A, int[] T, int[] L, int[] R) {
    List<Long> result = new ArrayList<>();
    LazySegTree lazySegTree = new LazySegTree(A);
    for (int i = 0; i < T.length; ++i) {
      if (T[i] == 1) {
        lazySegTree.update(L[i] - 1, R[i] - 1);
      } else {
        result.add(lazySegTree.queryInversion(L[i] - 1, R[i] - 1));
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}

class LazySegTree {
  Node root;

  LazySegTree(int[] values) {
    root = buildNode(values, 0, values.length - 1);
  }

  private Node buildNode(int[] values, int beginIndex, int endIndex) {
    Node node = new Node(beginIndex, endIndex, false);

    if (beginIndex == endIndex) {
      ++node.counts[values[beginIndex]];
      node.inversion = 0;
    } else {
      int middleIndex = (beginIndex + endIndex) / 2;
      node.left = buildNode(values, beginIndex, middleIndex);
      node.right = buildNode(values, middleIndex + 1, endIndex);

      node.pull();
    }

    return node;
  }

  void update(int beginIndex, int endIndex) {
    update(beginIndex, endIndex, root);
  }

  private void update(int beginIndex, int endIndex, Node node) {
    if (!(node.beginIndex > endIndex || node.endIndex < beginIndex)) {
      if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
        node.apply(true);
      } else {
        node.pushDown();

        update(beginIndex, endIndex, node.left);
        update(beginIndex, endIndex, node.right);

        node.pull();
      }
    }
  }

  long queryInversion(int beginIndex, int endIndex) {
    return queryInversion(beginIndex, endIndex, root);
  }

  private long queryInversion(int beginIndex, int endIndex, Node node) {
    if (node.beginIndex > endIndex || node.endIndex < beginIndex) {
      return 0;
    }
    if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
      return node.getComputedInversion();
    }

    node.pushDown();

    node.pull();

    return queryInversion(beginIndex, endIndex, node.left)
        + queryInversion(beginIndex, endIndex, node.right)
        + (long) queryCount(beginIndex, endIndex, 1, node.left)
            * queryCount(beginIndex, endIndex, 0, node.right);
  }

  private int queryCount(int beginIndex, int endIndex, int b, Node node) {
    if (node.beginIndex > endIndex || node.endIndex < beginIndex) {
      return 0;
    }
    if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
      return node.getComputedCount(b);
    }

    node.pushDown();

    node.pull();

    return queryCount(beginIndex, endIndex, b, node.left)
        + queryCount(beginIndex, endIndex, b, node.right);
  }

  static class Node {
    int beginIndex;
    int endIndex;
    boolean flipped;
    int[] counts = new int[2];
    long inversion;
    Node left;
    Node right;

    Node(int beginIndex, int endIndex, boolean flipped) {
      this.beginIndex = beginIndex;
      this.endIndex = endIndex;
      this.flipped = flipped;
    }

    int getComputedCount(int b) {
      return flipped ? counts[1 - b] : counts[b];
    }

    long getComputedInversion() {
      return flipped ? ((long) counts[0] * counts[1] - inversion) : inversion;
    }

    void pushDown() {
      left.apply(flipped);
      right.apply(flipped);

      flipped = false;
    }

    void apply(boolean f) {
      flipped ^= f;
    }

    void pull() {
      for (int b = 0; b < counts.length; ++b) {
        counts[b] = left.getComputedCount(b) + right.getComputedCount(b);
      }

      inversion =
          left.getComputedInversion()
              + right.getComputedInversion()
              + (long) left.getComputedCount(1) * right.getComputedCount(0);
    }
  }
}
