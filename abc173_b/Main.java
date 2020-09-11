import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static final String[] VERDICTS = { "AC", "WA", "TLE", "RE" };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] S = new String[N];
        for (int i = 0; i < S.length; ++i) {
            S[i] = sc.next();
        }
        System.out.println(solve(S));

        sc.close();
    }

    static String solve(String[] S) {
        int[] counts = new int[VERDICTS.length];
        for (String Si : S) {
            int index = IntStream.range(0, VERDICTS.length).filter(i -> VERDICTS[i].equals(Si)).findAny().getAsInt();
            ++counts[index];
        }

        return IntStream.range(0, VERDICTS.length).mapToObj(i -> String.format("%s x %d", VERDICTS[i], counts[i]))
                .collect(Collectors.joining("\n"));
    }
}