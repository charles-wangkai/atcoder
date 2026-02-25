import java.util.ArrayList;
import java.util.Arrays;
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
    sc.nextLine();
    String[] queries = new String[Q];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(A, queries));

    sc.close();
  }

  static String solve(int[] A, String[] queries) {
    List<Integer> result = new ArrayList<>();
    SegTree segTree = new SegTree(A);
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        int X = fields[1];
        int V = fields[2];

        segTree.update(X - 1, V);
      } else if (fields[0] == 2) {
        int L = fields[1];
        int R = fields[2];

        result.add(segTree.queryMaxValue(L - 1, R - 1));
      } else {
        int X = fields[1];
        int V = fields[2];

        int firstIndex = segTree.queryFirstIndex(X - 1, V);
        result.add((firstIndex == Integer.MAX_VALUE) ? (A.length + 1) : (firstIndex + 1));
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}

class SegTree {
  Node root;

  SegTree(int[] values) {
    root = buildNode(values, 0, values.length - 1);
  }

  private Node buildNode(int[] values, int beginIndex, int endIndex) {
    Node node = new Node(beginIndex, endIndex);

    if (beginIndex == endIndex) {
      node.maxValue = values[beginIndex];
    } else {
      int middleIndex = (beginIndex + endIndex) / 2;
      node.left = buildNode(values, beginIndex, middleIndex);
      node.right = buildNode(values, middleIndex + 1, endIndex);

      node.pull();
    }

    return node;
  }

  void update(int index, int value) {
    update(index, value, root);
  }

  private void update(int index, int value, Node node) {
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

  int queryMaxValue(int beginIndex, int endIndex) {
    return queryMaxValue(beginIndex, endIndex, root);
  }

  private int queryMaxValue(int beginIndex, int endIndex, Node node) {
    if (node.beginIndex > endIndex || node.endIndex < beginIndex) {
      return Integer.MIN_VALUE;
    }
    if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
      return node.maxValue;
    }

    return Math.max(
        queryMaxValue(beginIndex, endIndex, node.left),
        queryMaxValue(beginIndex, endIndex, node.right));
  }

  int queryFirstIndex(int beginIndex, int lowerLimit) {
    return queryFirstIndex(beginIndex, lowerLimit, root);
  }

  private int queryFirstIndex(int beginIndex, int lowerLimit, Node node) {
    if (node.endIndex < beginIndex || node.maxValue < lowerLimit) {
      return Integer.MAX_VALUE;
    }
    if (node.beginIndex == node.endIndex) {
      return node.beginIndex;
    }

    int leftIndex = queryFirstIndex(beginIndex, lowerLimit, node.left);

    return (leftIndex == Integer.MAX_VALUE)
        ? queryFirstIndex(beginIndex, lowerLimit, node.right)
        : leftIndex;
  }

  static class Node {
    int beginIndex;
    int endIndex;
    int maxValue;
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
