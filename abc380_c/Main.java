import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int K = sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S, K));

    sc.close();
  }

  static String solve(String S, int K) {
    List<Block> blocks = new ArrayList<>();
    int beginIndex = 0;
    for (int i = 0; i <= S.length(); ++i) {
      if (i == S.length() || S.charAt(i) == '0') {
        if (i != beginIndex) {
          blocks.add(new Block(beginIndex, i - beginIndex));
        }
        beginIndex = i + 1;
      }
    }

    char[] result = new char[S.length()];
    Arrays.fill(result, '0');
    for (int i = 0; i < blocks.size(); ++i) {
      int begin =
          (i == K - 1)
              ? (blocks.get(i - 1).beginIndex() + blocks.get(i - 1).length())
              : blocks.get(i).beginIndex();
      for (int j = 0; j < blocks.get(i).length(); ++j) {
        result[begin + j] = '1';
      }
    }

    return String.valueOf(result);
  }
}

record Block(int beginIndex, int length) {}
