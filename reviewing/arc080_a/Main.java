import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve(a) ? "Yes" : "No");

        sc.close();
    }

    static boolean solve(int[] a) {
        int countOdd = (int) Arrays.stream(a).filter(x -> x % 2 != 0).count();
        int count4 = (int) Arrays.stream(a).filter(x -> x % 4 == 0).count();

        return countOdd <= count4 || (countOdd == count4 + 1 && countOdd + count4 == a.length);
    }
}