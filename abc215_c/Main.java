import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();
    int K = sc.nextInt();

    System.out.println(solve(S, K));

    sc.close();
  }

  static String solve(String S, int K) {
    Set<String> permutations = new HashSet<>();
    search(permutations, S.toCharArray(), 0);

    return permutations.stream().sorted().skip(K - 1).findFirst().get();
  }

  static void search(Set<String> permutations, char[] letters, int index) {
    if (index == letters.length) {
      permutations.add(String.valueOf(letters));

      return;
    }

    for (int i = index; i < letters.length; ++i) {
      swap(letters, i, index);
      search(permutations, letters, index + 1);
      swap(letters, i, index);
    }
  }

  static void swap(char[] letters, int index1, int index2) {
    char temp = letters[index1];
    letters[index1] = letters[index2];
    letters[index2] = temp;
  }
}