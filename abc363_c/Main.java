import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int K = sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S, K));

    sc.close();
  }

  static int solve(String S, int K) {
    return search(K, S.toCharArray(), 0);
  }

  static boolean isPalindrome(char[] letters, int beginIndex, int endIndex) {
    for (int i = beginIndex, j = endIndex; i < j; ++i, --j) {
      if (letters[i] != letters[j]) {
        return false;
      }
    }

    return true;
  }

  static int search(int K, char[] letters, int index) {
    if (index == letters.length) {
      return 1;
    }

    int result = 0;
    Set<Character> seen = new HashSet<>();
    for (int i = index; i < letters.length; ++i) {
      swap(letters, i, index);

      if (!seen.contains(letters[index])
          && (index - K + 1 < 0 || !isPalindrome(letters, index - K + 1, index))) {
        seen.add(letters[index]);

        result += search(K, letters, index + 1);
      }

      swap(letters, i, index);
    }

    return result;
  }

  static void swap(char[] a, int index1, int index2) {
    char temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }
}