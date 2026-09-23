import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[M];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(N, A));

    sc.close();
  }

  static String solve(int N, int[] A) {
    Map<Integer, Integer> candidateToVoteCount = new HashMap<>();
    SortedMap<Integer, SortedSet<Integer>> voteCountToCandidates = new TreeMap<>();

    int[] result = new int[A.length];
    for (int i = 0; i < result.length; ++i) {
      int oldVoteCount = candidateToVoteCount.getOrDefault(A[i], 0);
      int newVoteCount = oldVoteCount + 1;

      if (oldVoteCount != 0) {
        voteCountToCandidates.get(oldVoteCount).remove(A[i]);
        if (voteCountToCandidates.get(oldVoteCount).isEmpty()) {
          voteCountToCandidates.remove(oldVoteCount);
        }
      }

      candidateToVoteCount.put(A[i], newVoteCount);

      voteCountToCandidates.putIfAbsent(newVoteCount, new TreeSet<>());
      voteCountToCandidates.get(newVoteCount).add(A[i]);

      result[i] = voteCountToCandidates.lastEntry().getValue().first();
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}