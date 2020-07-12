import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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

    static long solve(int[] s) {
        long result = 0;
        for (int delta = 1; delta * 2 < s.length - 1; ++delta) {
            Set<Integer> backIndices = new HashSet<>();
            int backIndex = delta;
            long backSum = 0;
            while (backIndex < s.length - 1 - delta) {
                backSum += s[backIndex];
                backIndices.add(backIndex);
                backIndex += delta;
            }

            Set<Integer> frontIndices = new HashSet<>();
            int frontIndex = s.length - 1 - delta;
            long frontSum = 0;
            int duplicateCount = 0;
            for (int i = 0; i < backIndices.size(); ++i) {
                if (backIndices.contains(frontIndex)) {
                    ++duplicateCount;
                }

                frontSum += s[frontIndex];
                frontIndices.add(frontIndex);
                frontIndex -= delta;
            }

            int lastBackIndex = backIndex - delta;
            int firstFrontIndex = frontIndex + delta;
            while (!frontIndices.isEmpty()) {
                if (duplicateCount == 0) {
                    result = Math.max(result, frontSum + backSum);
                }

                if (frontIndices.contains(lastBackIndex)) {
                    --duplicateCount;
                }
                backSum -= s[lastBackIndex];
                backIndices.remove(lastBackIndex);
                lastBackIndex -= delta;

                if (backIndices.contains(firstFrontIndex)) {
                    --duplicateCount;
                }
                frontSum -= s[firstFrontIndex];
                frontIndices.remove(firstFrontIndex);
                firstFrontIndex += delta;
            }
        }

        return result;
    }
}