import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] s = new int[N];
        for (int i = 0; i < s.length; ++i) {
            s[i] = sc.nextInt();
        }

        System.out.println(solve(s));

        sc.close();
    }

    static int solve(int[] s) {
        int sum = Arrays.stream(s).sum();
        if (sum % 10 != 0) {
            return sum;
        }

        return Arrays.stream(s).allMatch(si -> si % 10 == 0) ? 0
                : (sum - Arrays.stream(s).filter(si -> si % 10 != 0).min().getAsInt());
    }
}