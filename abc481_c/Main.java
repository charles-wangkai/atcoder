import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int Q = sc.nextInt();
    String[] names = new String[Q];
    for (int i = 0; i < names.length; ++i) {
      names[i] = sc.next();
    }

    System.out.println(solve(names));

    sc.close();
  }

  static String solve(String[] names) {
    int[] result = new int[names.length];
    Map<String, Integer> nameToId = new HashMap<>();
    for (int i = 0; i < result.length; ++i) {
      nameToId.putIfAbsent(names[i], nameToId.size() + 1);
      result[i] = nameToId.get(names[i]);
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}