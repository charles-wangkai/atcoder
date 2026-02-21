import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int K = sc.nextInt();

        System.out.println(solve(s, K));

        sc.close();
    }

    static String solve(String s, int K) {
        List<String> candidates = new ArrayList<>();
        for (int beginIndex = 0; beginIndex < s.length(); ++beginIndex) {
            for (int endIndex = beginIndex; endIndex < s.length() && endIndex - beginIndex + 1 <= K; ++endIndex) {
                candidates.add(s.substring(beginIndex, endIndex + 1));
            }
        }

        return candidates.stream().distinct().sorted().skip(K - 1).findFirst().get();
    }
}