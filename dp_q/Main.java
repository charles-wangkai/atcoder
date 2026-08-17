import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] h = new int[N];
    for (int i = 0; i < h.length; ++i) {
      h[i] = sc.nextInt();
    }
    int[] a = new int[N];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(h, a));

    sc.close();
  }

  static long solve(int[] h, int[] a) {
    int N = h.length;

    SegTree segTree = new SegTree(N + 1);
    for (int i = 0; i < N; ++i) {
      segTree.update(h[i], segTree.query(0, h[i] - 1) + a[i]);
    }

    return segTree.query(0, N);
  }
}

class SegTree {
  Node root;

  SegTree(int size) {
    root = buildNode(0, size - 1);
  }

  private Node buildNode(int beginIndex, int endIndex) {
    Node node = new Node(beginIndex, endIndex);

    if (beginIndex == endIndex) {
      node.maxValue = 0;
    } else {
      int middleIndex = (beginIndex + endIndex) / 2;
      node.left = buildNode(beginIndex, middleIndex);
      node.right = buildNode(middleIndex + 1, endIndex);

      node.pull();
    }

    return node;
  }

  void update(int index, long value) {
    update(index, value, root);
  }

  private void update(int index, long value, Node node) {
    if (node.beginIndex <= index && node.endIndex >= index) {
      if (node.beginIndex == node.endIndex) {
        node.maxValue = value;
      } else {
        update(index, value, node.left);
        update(index, value, node.right);

        node.pull();
      }
    }
  }

  long query(int beginIndex, int endIndex) {
    return query(beginIndex, endIndex, root);
  }

  private long query(int beginIndex, int endIndex, Node node) {
    if (node.beginIndex > endIndex || node.endIndex < beginIndex) {
      return 0;
    }
    if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
      return node.maxValue;
    }

    return Math.max(
        query(beginIndex, endIndex, node.left), query(beginIndex, endIndex, node.right));
  }

  static class Node {
    int beginIndex;
    int endIndex;
    long maxValue;
    Node left;
    Node right;

    Node(int beginIndex, int endIndex) {
      this.beginIndex = beginIndex;
      this.endIndex = endIndex;
    }

    void pull() {
      maxValue = Math.max(left.maxValue, right.maxValue);
    }
  }
}
