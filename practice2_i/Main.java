// https://atcoder.github.io/ac-library/master/document_en/string.html

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static long solve(String S) {
    return S.length() * (S.length() + 1L) / 2
        - Arrays.stream(StringAlgo.buildLcpArray(S, StringAlgo.buildSuffixArray(S)))
            .asLongStream()
            .sum();
  }
}

class StringAlgo {
  static int[] buildSuffixArray(String s) {
    int n = s.length();

    Integer[] suffixArray = new Integer[n + 1];
    int[] ranks = new int[n + 1];
    for (int i = 0; i <= n; ++i) {
      suffixArray[i] = i;
      ranks[i] = (i == n) ? -1 : s.charAt(i);
    }

    for (int k = 1; k <= n; k *= 2) {
      int[] ranks_ = ranks;
      int k_ = k;
      Comparator<Integer> comparator =
          Comparator.<Integer, Integer>comparing(i -> ranks_[i])
              .thenComparing(i -> (i + k_ < ranks_.length) ? ranks_[i + k_] : -1);

      Arrays.sort(suffixArray, comparator);

      int[] nextRanks = new int[ranks.length];
      for (int i = 1; i <= n; ++i) {
        nextRanks[suffixArray[i]] =
            nextRanks[suffixArray[i - 1]]
                + ((comparator.compare(suffixArray[i - 1], suffixArray[i]) == 0) ? 0 : 1);
      }

      ranks = nextRanks;
    }

    return Arrays.stream(suffixArray).mapToInt(Integer::intValue).toArray();
  }

  static int[] buildLcpArray(String s, int[] suffixArray) {
    int n = s.length();

    int[] ranks = new int[n + 1];
    for (int i = 0; i <= n; ++i) {
      ranks[suffixArray[i]] = i;
    }

    int[] result = new int[n];
    int h = 0;
    for (int i = 0; i < n; ++i) {
      if (h != 0) {
        --h;
      }

      int j = suffixArray[ranks[i] - 1];
      while (j + h < n && i + h < n && s.charAt(j + h) == s.charAt(i + h)) {
        ++h;
      }

      result[ranks[i] - 1] = h;
    }

    return result;
  }

  static int[] buildZArray(String s) {
    int n = s.length();

    int[] z = new int[n];
    int l = 0;
    int r = 0;
    for (int i = 1; i < n; ++i) {
      if (i < r) {
        z[i] = Math.min(r - i, z[i - l]);
      }
      while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
        ++z[i];
      }
      if (i + z[i] > r) {
        l = i;
        r = i + z[i];
      }
    }

    return z;
  }
}
