import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] p = new int[N];
        for (int i = 0; i < p.length; ++i) {
            p[i] = sc.nextInt();
        }

        System.out.println(solve(p));

        sc.close();
    }

    static int solve(int[] p) {
        int result = 0;
        for (int i = 0; i < p.length; ++i) {
            if (p[i] == i + 1) {
                if (i != p.length - 1) {
                    swap(p, i, i + 1);
                } else {
                    swap(p, i, i - 1);
                }

                ++result;
            }
        }

        return result;
    }

    static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}