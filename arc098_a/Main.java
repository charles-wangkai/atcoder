import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextInt();
        String S = sc.next();

        System.out.println(solve(S));

        sc.close();
    }

    static int solve(String S) {
        int N = S.length();

        int leftWCount = 0;
        int[] leftWCounts = new int[N];
        for (int i = 0; i < leftWCounts.length; ++i) {
            leftWCounts[i] = leftWCount;

            if (S.charAt(i) == 'W') {
                ++leftWCount;
            }
        }

        int rightECount = 0;
        int[] rightECounts = new int[N];
        for (int i = rightECounts.length - 1; i >= 0; --i) {
            rightECounts[i] = rightECount;

            if (S.charAt(i) == 'E') {
                ++rightECount;
            }
        }

        return IntStream.range(0, N).map(i -> leftWCounts[i] + rightECounts[i]).min().getAsInt();
    }
}