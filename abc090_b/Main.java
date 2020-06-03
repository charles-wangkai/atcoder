import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(solve(A, B));

        sc.close();
    }

    static int solve(int A, int B) {
        return (int) IntStream.rangeClosed(A, B).filter(x -> isPalindrome(String.valueOf(x))).count();
    }

    static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}