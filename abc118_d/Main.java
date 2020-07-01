import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static final int[] STICK_NUMS = { -1, 2, 5, 5, 4, 5, 6, 3, 7, 6 };

    static BigInteger solution;
    static int lengthForSolution;

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

    static BigInteger solve(int N, int[] A) {
        Map<Integer, Integer> stickNumToDigit = new HashMap<>();
        for (int digit : A) {
            stickNumToDigit.put(STICK_NUMS[digit], Math.max(stickNumToDigit.getOrDefault(STICK_NUMS[digit], 0), digit));
        }

        int[] stickNums = stickNumToDigit.keySet().stream().sorted().mapToInt(x -> x).toArray();

        lengthForSolution = 0;
        solution = BigInteger.ZERO;
        search(stickNumToDigit, stickNums, new int[stickNums.length], 0, 0, N);

        return solution;
    }

    static void search(Map<Integer, Integer> stickNumToDigit, int[] stickNums, int[] lengths, int index,
            int totalLength, int rest) {
        if (index == lengths.length) {
            List<Integer> digits = new ArrayList<>();
            for (int i = 0; i < lengths.length; ++i) {
                for (int j = 0; j < lengths[i]; ++j) {
                    digits.add(stickNumToDigit.get(stickNums[i]));
                }
            }

            String s = digits.stream().sorted(Collections.reverseOrder()).map(String::valueOf)
                    .collect(Collectors.joining());
            BigInteger current = new BigInteger(s);
            if (current.compareTo(solution) > 0) {
                solution = current;
                lengthForSolution = s.length();
            }

            return;
        }

        if (totalLength + rest / stickNums[index] < lengthForSolution) {
            return;
        }

        if (index == lengths.length - 1) {
            if (rest % stickNums[index] == 0) {
                lengths[index] = rest / stickNums[index];
                search(stickNumToDigit, stickNums, lengths, index + 1, totalLength + lengths[index], 0);
            }

            return;
        }

        for (int length = rest / stickNums[index]; length >= 0; --length) {
            lengths[index] = length;
            search(stickNumToDigit, stickNums, lengths, index + 1, totalLength + lengths[index],
                    rest - stickNums[index] * lengths[index]);
        }
    }
}