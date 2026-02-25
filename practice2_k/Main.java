import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final ModInt MOD_INT = new ModInt(998_244_353);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    int[] a = new int[N];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    sc.nextLine();
    String[] queries = new String[Q];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(a, queries));

    sc.close();
  }

  static String solve(int[] a, String[] queries) {
    List<Integer> result = new ArrayList<>();
    LazySegTree lazySegTree = new LazySegTree(a);
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 0) {
        int l = fields[1];
        int r = fields[2];
        int b = fields[3];
        int c = fields[4];

        lazySegTree.update(l, r - 1, b, c);
      } else {
        int l = fields[1];
        int r = fields[2];

        result.add(lazySegTree.query(l, r - 1));
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
    Node node = new Node(beginIndex, endIndex, 1, 0);

    if (beginIndex == endIndex) {
      node.sum = values[beginIndex];
    } else {
      int middleIndex = (beginIndex + endIndex) / 2;
      node.left = buildNode(values, beginIndex, middleIndex);
      node.right = buildNode(values, middleIndex + 1, endIndex);

      node.pull();
    }

    return node;
  }

  void update(int beginIndex, int endIndex, int factor, int offset) {
    update(beginIndex, endIndex, factor, offset, root);
  }

  private void update(int beginIndex, int endIndex, int factor, int offset, Node node) {
    if (!(node.beginIndex > endIndex || node.endIndex < beginIndex)) {
      if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
        node.apply(factor, offset);
      } else {
        node.pushDown();

        update(beginIndex, endIndex, factor, offset, node.left);
        update(beginIndex, endIndex, factor, offset, node.right);

        node.pull();
      }
    }
  }

  int query(int beginIndex, int endIndex) {
    return query(beginIndex, endIndex, root);
  }

  private int query(int beginIndex, int endIndex, Node node) {
    if (node.beginIndex > endIndex || node.endIndex < beginIndex) {
      return 0;
    }
    if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
      return node.getComputedSum();
    }

    node.pushDown();

    node.pull();

    return Main.MOD_INT.addMod(
        query(beginIndex, endIndex, node.left), query(beginIndex, endIndex, node.right));
  }

  static class Node {
    int beginIndex;
    int endIndex;
    int factor;
    int offset;
    int sum;
    Node left;
    Node right;

    Node(int beginIndex, int endIndex, int factor, int offset) {
      this.beginIndex = beginIndex;
      this.endIndex = endIndex;
      this.factor = factor;
      this.offset = offset;
    }

    int getComputedSum() {
      return Main.MOD_INT.addMod(
          Main.MOD_INT.multiplyMod(factor, sum),
          Main.MOD_INT.multiplyMod(offset, endIndex - beginIndex + 1));
    }

    void pushDown() {
      left.apply(factor, offset);
      right.apply(factor, offset);

      factor = 1;
      offset = 0;
    }

    void apply(int f, int o) {
      factor = Main.MOD_INT.multiplyMod(factor, f);
      offset = Main.MOD_INT.addMod(Main.MOD_INT.multiplyMod(f, offset), o);
    }

    void pull() {
      sum = Main.MOD_INT.addMod(left.getComputedSum(), right.getComputedSum());
    }
  }
}

class ModInt {
  int modulus;

  ModInt(int modulus) {
    this.modulus = modulus;
  }

  int mod(long x) {
    return Math.floorMod(x, modulus);
  }

  int modInv(int x) {
    return BigInteger.valueOf(x).modInverse(BigInteger.valueOf(modulus)).intValue();
  }

  int addMod(int x, int y) {
    return mod(x + y);
  }

  int multiplyMod(int x, int y) {
    return mod((long) x * y);
  }

  int divideMod(int x, int y) {
    return multiplyMod(x, modInv(y));
  }

  int powMod(int base, long exponent) {
    if (exponent == 0) {
      return 1;
    }

    return multiplyMod(
        (exponent % 2 == 0) ? 1 : base, powMod(multiplyMod(base, base), exponent / 2));
  }
}
