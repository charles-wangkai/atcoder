import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve(a));

        sc.close();
    }

    static String solve(int[] a) {
        int[] result = new int[a.length];
        int leftIndex;
        int rightIndex;
        boolean leftOrRight;
        if (a.length % 2 == 0) {
            leftIndex = a.length / 2 - 1;
            rightIndex = a.length / 2;
            leftOrRight = false;
        } else {
            leftIndex = a.length / 2;
            rightIndex = a.length / 2 + 1;
            leftOrRight = true;
        }

        for (int i = 0; i < a.length; ++i) {
            if (leftOrRight) {
                result[leftIndex] = a[i];
                --leftIndex;
            } else {
                result[rightIndex] = a[i];
                ++rightIndex;
            }

            leftOrRight = !leftOrRight;
        }

        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}