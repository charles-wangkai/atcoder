import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S) {
    Map<Character, Integer> letterToFreq = new HashMap<>();
    for (char letter : S.toCharArray()) {
      letterToFreq.put(letter, letterToFreq.getOrDefault(letter, 0) + 1);
    }

    Map<Integer, Integer> freqToCount = new HashMap<>();
    for (int freq : letterToFreq.values()) {
      freqToCount.put(freq, freqToCount.getOrDefault(freq, 0) + 1);
    }

    return freqToCount.values().stream().allMatch(count -> count == 2);
  }
}