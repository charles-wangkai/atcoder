import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    int[] X = new int[Q];
    int[] Y = new int[Q];
    for (int i = 0; i < Q; ++i) {
      X[i] = sc.nextInt();
      Y[i] = sc.nextInt();
    }

    System.out.println(solve(N, X, Y));

    sc.close();
  }

  static String solve(int N, int[] X, int[] Y) {
    SortedMap<Integer, Integer> versionToCount = new TreeMap<>();
    for (int i = 1; i <= N; ++i) {
      updateMap(versionToCount, i, 1);
    }

    int[] result = new int[X.length];
    for (int i = 0; i < result.length; ++i) {
      while (true) {
        int minVersion = versionToCount.firstKey();
        if (minVersion > X[i]) {
          break;
        }

        int count = versionToCount.get(minVersion);
        updateMap(versionToCount, minVersion, -count);
        updateMap(versionToCount, Y[i], count);
        result[i] += count;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }

  static void updateMap(SortedMap<Integer, Integer> versionToCount, int version, int delta) {
    versionToCount.put(version, versionToCount.getOrDefault(version, 0) + delta);
    versionToCount.remove(version, 0);
  }
}