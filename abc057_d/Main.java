import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        long[] v = new long[N];
        for (int i = 0; i < v.length; ++i) {
            v[i] = sc.nextLong();
        }

        System.out.println(solve(v, A, B));

        sc.close();
    }

    static String solve(long[] v, int A, int B) {
        v = Arrays.stream(v).boxed().sorted(Collections.reverseOrder()).mapToLong(x -> x).toArray();

        long[] v_ = v;
        double avg = IntStream.range(0, A).mapToLong(i -> v_[i]).average().getAsDouble();

        long last = v[A - 1];
        int lastCount = (int) Arrays.stream(v).filter(x -> x == last).count();
        int lastChosen = (int) IntStream.range(0, A).filter(i -> v_[i] == last).count();
        long wayNum = C(lastCount, lastChosen);
        if (v[0] == last) {
            for (int i = A + 1; i <= B && v[i - 1] == last; ++i) {
                ++lastChosen;
                wayNum += C(lastCount, lastChosen);
            }
        }

        return String.format("%f\n%d", avg, wayNum);
    }

    static long C(int n, int r) {
        long result = 1;
        for (int i = 0; i < r; ++i) {
            result = result * (n - i) / (i + 1);
        }

        return result;
    }
}